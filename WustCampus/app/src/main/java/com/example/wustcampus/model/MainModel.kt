package com.example.wustcampus.model

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.commonlib.isNetworkAvailable
import com.example.commonlib.logd
import com.example.commonlib.loge
import com.example.wustcampus.repository.CourseRepository
import com.example.wustcampus.repository.UserRepository
import com.example.wustcampus.util.DrawableUtils
import kotlinx.coroutines.*
import java.lang.Exception

class MainModel(val app: Application) : AndroidViewModel(app) {
    fun fetchCourse(semester: String) {
        if (!isNetworkAvailable(app)) {
            return
        }
        val studentId = UserRepository.getUserAccount(app)
        val password = UserRepository.getUserPassword(app)
        if (TextUtils.isEmpty(studentId) || TextUtils.isEmpty(password)) {
            return
        }
        viewModelScope.launch {
            try {
                val courseRsp = CourseRepository.fetchCourse(studentId, password, semester, this)
                courseRsp?.takeIf {
                    it.code == 1
                }?.takeIf {
                    it.data.isNotEmpty()
                }?.let {
                    withContext(viewModelScope.coroutineContext + Dispatchers.Default) {
                        UserRepository.saveUserInfo(
                            ctx = app,
                            studentId = studentId,
                            studentName = "",
                            semester = semester
                        )
                        logd(MainModel::class.java, "save userInfo")
                        it.data.forEach {
                            logd(MainModel::class.java, it.className)
                            CourseRepository
                                .addCourse(
                                    ctx = app,
                                    studentId = studentId,
                                    className = it.className,
                                    teacher = it.teacher,
                                    classRoom = it.classRoom,
                                    weekday = it.weekday,
                                    startWeek = it.startWeek,
                                    endWeek = it.endWeek,
                                    time = it.time,
                                    color = DrawableUtils.getColorIndex(app, studentId, semester),
                                    isDefault = true,
                                    semester = semester,
                                    classNo = it.classNo
                                )
                        }
                        logd(MainModel::class.java, "Database save successfully!")
                    }
                }
            } catch (e: CancellationException) {
                loge(MainModel::class.java, e.message ?: "")
            } catch (e: Exception) {
                loge(MainModel::class.java, e.message ?: "")
            }
        }
    }
}