package com.example.wustcampus.model

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.commonlib.isNetworkAvailable
import com.example.wustcampus.R
import com.example.wustcampus.datasource.SharePreferenceUtils
import com.example.wustcampus.repository.UserRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import java.lang.Exception

class UserModel(private val app: Application): AndroidViewModel(app) {
    val isJumpToMainFragment = MutableLiveData<Boolean>()
    val loginToast = MutableLiveData<String>()

    fun checkIsLogin() {
        isJumpToMainFragment.value = UserRepository.isLogin(app)
    }

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
                    isJumpToMainFragment.value = true
                    UserRepository.setIsLogin(app, true)
                    UserRepository.saveUserInfo(app, account, password)
                    loginToast.value = app.getString(R.string.loginSuccess)
                    return@launch
                } 
                isJumpToMainFragment.value = false
                loginToast.value = app.getString(R.string.loginFail)
            } catch (e: CancellationException) {
                isJumpToMainFragment.value = false
                loginToast.value = app.getString(R.string.loginCancel)
            } catch (e: Exception) {
                isJumpToMainFragment.value = false
                loginToast.value = app.getString(R.string.loginFail)
            }
        }
    }

}