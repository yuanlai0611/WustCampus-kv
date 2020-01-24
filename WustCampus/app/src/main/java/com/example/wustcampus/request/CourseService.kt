package com.example.wustcampus.request

import com.example.wustcampus.request.api.CourseApi
import com.example.wustcampus.request.bean.ComRsp
import com.example.wustcampus.request.bean.CourseRsp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CourseService {
    private const val BASE_URL = "http://47.100.207.45:8086/api/"
    private const val TIME_OUT: Long = 15

    private val retrofit by lazy {
        val client = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private val courseApi by lazy {
        retrofit.create(CourseApi::class.java)
    }

    /**
     * 获取课程信息
     */
    suspend fun fetchCourse(studentId: String, password: String, semester: String): ComRsp<CourseRsp> {
        return courseApi
            .fetchCourse(studentId, password, semester)
            .await()
    }
}