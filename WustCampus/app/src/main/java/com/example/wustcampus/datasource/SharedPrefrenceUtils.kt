package com.example.wustcampus.datasource

import android.content.Context
import android.content.Context.MODE_PRIVATE

object SharePreferenceUtils {

    private const val USER = "user"
    private const val IS_LOGIN = "isLogin"
    private const val ACCOUNT = "account"
    private const val PASSWORD = "password"

    fun getIsLogin(ctx: Context): Boolean {
        return ctx.getSharedPreferences(USER, MODE_PRIVATE)
            ?.run {
                getBoolean(IS_LOGIN, false)
            } ?: false
    }

    fun setIsLogin(ctx: Context, isLogin: Boolean) {
        ctx.getSharedPreferences(USER, MODE_PRIVATE)
            ?.edit()?.apply{
                this.putBoolean(IS_LOGIN, isLogin)
                this.apply()
            }
    }

    fun saveUserInfo(ctx: Context, account: String, password: String) {
        ctx.getSharedPreferences(USER, MODE_PRIVATE)
            ?.edit()?.apply{
                this.putString(ACCOUNT, account)
                this.putString(PASSWORD, password)
                this.apply()
            }
    }

    fun getAccount(ctx: Context): String {
        return ctx.getSharedPreferences(USER, MODE_PRIVATE)
            ?.run {
                this.getString(ACCOUNT, "")
            } ?: ""
    }

    fun getPassword(ctx: Context): String {
        return ctx.getSharedPreferences(USER, MODE_PRIVATE)
            ?.run {
                this.getString(PASSWORD, "")
            } ?: ""
    }
}