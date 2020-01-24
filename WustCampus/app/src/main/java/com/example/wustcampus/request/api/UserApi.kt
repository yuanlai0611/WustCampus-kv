package com.example.wustcampus.request.api

import com.example.wustcampus.request.bean.LoginRsp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("StuLogin")
    fun login(
        @Query("StudentID") studentId: String,
        @Query("Password") password: String,
        @Query("Time") time: String,
        @Query("CheckValue") checkValue: String
    ): Call<LoginRsp>
}