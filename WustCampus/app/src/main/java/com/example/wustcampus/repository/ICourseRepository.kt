package com.example.wustcampus.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.wustcampus.datasource.db.databean.CourseBean
import com.example.wustcampus.request.bean.ComRsp
import com.example.wustcampus.request.bean.CourseRsp
import kotlinx.coroutines.CoroutineScope

interface ICourseRepository {
    fun addCourse(
        ctx: Context,
        studentId: Long,
        className: String,
        teacher: String,
        classRoom: String,
        weekday: Int,
        startWeek: Int,
        endWeek: Int,
        time: Int,
        color: Int,
        isDefault: Boolean,
        semester: String,
        classNo: String
    )

    fun deleteCourse(
        ctx: Context,
        studentId: Long,
        startWeek: Int,
        endWeek: Int,
        weekday: Int,
        time: Int,
        className: String,
        semester: String,
        classNo: String,
        teacher: String
    )

    fun queryCourseByWeekday(
        ctx: Context,
        studentId: Long,
        weekday: Int,
        semester: String
    ): LiveData<List<CourseBean>>

    fun queryCourse(
        ctx: Context,
        studentId: Long,
        semester: String,
        week: Int,
        weekday: Int,
        time: Int
    ): CourseBean

    fun isExist(
        ctx: Context,
        studentId: Long,
        semester: String
    ): Boolean

    suspend fun fetchCourse(
        studentId: String,
        password: String,
        semester: String,
        scope: CoroutineScope
    ): ComRsp<CourseRsp>?
}