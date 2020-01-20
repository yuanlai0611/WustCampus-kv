package com.example.wustcampus.model

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.commonlib.isNetworkAvailable
import com.example.wustcampus.R
import com.example.wustcampus.repository.UserRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import java.lang.Exception

class UserModel(private val app: Application): AndroidViewModel(app) {
    val isLoginSuccess = MutableLiveData<Boolean>()
    val loginToast = MutableLiveData<String>()
    

    fun login(account: String, password: String) {
        if (!isNetworkAvailable(app)) {
            return
        }
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            return
        }
        viewModelScope.launch {
            try {
                val loginRsp = UserRepository.login(account, password, this)
                loginRsp?.takeIf {
                    it.code == 1
                }?.let {
                    isLoginSuccess.value = true
                    loginToast.value = app.getString(R.string.loginSuccess)
                    return@launch
                } 
                isLoginSuccess.value = false
                loginToast.value = app.getString(R.string.loginFail)
            } catch (e: CancellationException) {
                isLoginSuccess.value = false
                loginToast.value = app.getString(R.string.loginCancel)
            } catch (e: Exception) {
                isLoginSuccess.value = false
                loginToast.value = app.getString(R.string.loginFail)
            }
        }
    }

}