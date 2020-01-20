package com.example.wustcampus.repository

import com.example.wustcampus.request.bean.LoginRsp
import kotlinx.coroutines.CoroutineScope

interface IUserRepository {
    suspend fun login(account: String, password: String, scope: CoroutineScope): LoginRsp?
}
