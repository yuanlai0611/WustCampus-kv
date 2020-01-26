package com.example.wustcampus.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import com.example.wustcampus.datasource.SharePreferenceUtils
import com.example.wustcampus.datasource.db.databean.CourseBean
import com.example.wustcampus.request.bean.LoginRsp
import kotlinx.coroutines.CoroutineScope

interface IUserRepository {
    suspend fun login(
        account: String,
        password: String,
        scope: CoroutineScope
    ): LoginRsp?

    fun saveUserInfo(
        ctx: Context,
        studentId: String,
        studentName: String,
        semester: String
    )

    fun setIsLogin(
        ctx: Context,
        isLogin: Boolean
    )

    fun isLogin(
        ctx: Context
    ): Boolean

    fun saveUserInfo(
        ctx: Context,
        account: String,
        password: String
    )

    fun getUserAccount(
        ctx: Context
    ): String?

    fun getUserPassword(
        ctx: Context
    ): String?
}
