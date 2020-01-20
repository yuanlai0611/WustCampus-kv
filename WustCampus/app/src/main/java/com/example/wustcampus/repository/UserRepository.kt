package com.example.wustcampus.repository

import com.example.wustcampus.request.ComService
import com.example.wustcampus.request.bean.LoginRsp
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object UserRepository: IUserRepository{
    @Throws(CancellationException::class)
    override suspend fun login(account: String, password: String, scope: CoroutineScope): LoginRsp? {
        return withContext(scope.coroutineContext + Dispatchers.Default) {
            ComService.login(account, password)
        }
    }
}