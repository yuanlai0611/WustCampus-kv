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
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import java.lang.Exception

class MainModel(val app: Application): AndroidViewModel(app) {
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
                    courseRsp.code == 1
                }?.let {
                    logd(MainModel::class.java, courseRsp.data.toString())
                }
            } catch (e: CancellationException) {
                loge(MainModel::class.java, e.message?:"")
            } catch (e: Exception) {
                loge(MainModel::class.java, e.message?:"")
            }
        }
    }
}