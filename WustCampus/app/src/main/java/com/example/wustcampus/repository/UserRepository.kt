package com.example.wustcampus.repository

import android.content.Context
import com.example.wustcampus.datasource.SharePreferenceUtils
import com.example.wustcampus.request.AppService
import com.example.wustcampus.request.bean.LoginRsp
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object UserRepository: IUserRepository{
    @Throws(CancellationException::class)
    override suspend fun login(account: String, password: String, scope: CoroutineScope): LoginRsp? {
        return withContext(scope.coroutineContext + Dispatchers.Default) {
            AppService.login(account, password)
        }
    }

    override fun setIsLogin(ctx: Context, isLogin: Boolean) {
        SharePreferenceUtils.setIsLogin(ctx, isLogin)
    }

    override fun isLogin(ctx: Context): Boolean {
        return SharePreferenceUtils.getIsLogin(ctx)
    }

    override fun saveUserInfo(ctx: Context, account: String, password: String) {
        SharePreferenceUtils.saveUserInfo(ctx, account, password)
    }

    override fun getUserAccount(ctx: Context): String {
        return SharePreferenceUtils.getAccount(ctx)
    }

    override fun getUserPassword(ctx: Context): String {
        return SharePreferenceUtils.getPassword(ctx)
    }
}