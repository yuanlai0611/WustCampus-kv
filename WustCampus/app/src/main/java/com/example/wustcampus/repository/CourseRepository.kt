package com.example.wustcampus.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.wustcampus.datasource.db.AppDatabase
import com.example.wustcampus.datasource.db.databean.CourseBean
import com.example.wustcampus.request.AppService
import com.example.wustcampus.request.CourseService
import com.example.wustcampus.request.bean.ComRsp
import com.example.wustcampus.request.bean.CourseRsp
import kotlinx.coroutines.*

object CourseRepository : ICourseRepository {
    override fun addCourse(
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
    ) {
        AppDatabase
            .getInstance(ctx)
            .courseDao()
            .insertCourseBean(
                CourseBean(
                    studentId = studentId,
                    weekDay = weekday,
                    className = className,
                    teacher = teacher,
                    startWeek = startWeek,
                    endWeek = endWeek,
                    time = time,
                    classRoom = classRoom,
                    color = color,
                    isDefault = isDefault,
                    semester = semester,
                    classNo = classNo
                )
            )
    }

    override fun deleteCourse(
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
    ) {
        AppDatabase
            .getInstance(ctx)
            .courseDao()
            .deleteCourseBean(
                CourseBean(
                    studentId = studentId,
                    weekDay = weekday,
                    className = className,
                    teacher = teacher,
                    startWeek = startWeek,
                    endWeek = endWeek,
                    time = time,
                    classRoom = "",
                    color = 0,
                    isDefault = false,
                    semester = semester,
                    classNo = classNo
                )
            )
    }

    override fun queryCourseByWeekday(
        ctx: Context,
        studentId: Long,
        weekday: Int,
        semester: String
    ): LiveData<List<CourseBean>> {
        return AppDatabase
            .getInstance(ctx)
            .courseDao()
            .query(studentId, weekday, semester)
    }

    override fun queryCourse(
        ctx: Context,
        studentId: Long,
        semester: String,
        week: Int,
        weekday: Int,
        time: Int
    ): CourseBean {
        return AppDatabase
            .getInstance(ctx)
            .courseDao()
            .query(studentId, week, weekday, time, semester)
    }

    override fun isExist(ctx: Context, studentId: Long, semester: String): Boolean {
        return AppDatabase.getInstance(ctx).courseDao().query(studentId, semester) > 0
    }

    @Throws(CancellationException::class)
    override suspend fun fetchCourse(
        studentId: String,
        password: String,
        semester: String,
        scope: CoroutineScope
    ): ComRsp<CourseRsp>? {
        return withContext(scope.coroutineContext + Dispatchers.Default) {
            CourseService.fetchCourse(studentId, password, semester)
        }
    }
}