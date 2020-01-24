package com.example.wustcampus.request.api

import com.example.wustcampus.request.bean.ComRsp
import com.example.wustcampus.request.bean.CourseRsp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CourseApi {
    @GET("GetClassByStudentID")
    fun fetchCourse(
        @Query("StudentID") studentId: String,
        @Query("Password") password: String,
        @Query("Xq") semester: String
    ): Call<ComRsp<CourseRsp>>
}