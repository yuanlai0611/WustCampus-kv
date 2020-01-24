package com.example.wustcampus.request

import com.example.commonlib.md5
import com.example.wustcampus.request.api.UserApi
import com.example.wustcampus.request.bean.LoginRsp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object AppService {
    private const val BASE_URL = "http://lh.iwust.cn/api/AndroidApi/"
    private const val KEY = "NewWustHelperWithAndroid2018"
    private const val TIME_OUT: Long = 15
    private val retrofit by lazy {
        val client = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT,TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private val userApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    /**
     * 登录请求
     */
    suspend fun login(account: String, password: String): LoginRsp {
        val currentTime = System.currentTimeMillis()
        val md5str = md5(KEY + currentTime)
        return userApi
            .login(account, password, currentTime.toString(), md5str.substring(3, 18).toUpperCase(Locale.CHINA))
            .await()
    }
}