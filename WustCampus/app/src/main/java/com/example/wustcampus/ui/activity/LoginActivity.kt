package com.example.wustcampus.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.commonlib.logd
import com.example.commonlib.setFitNotch
import com.example.wustcampus.R
import com.example.wustcampus.ui.callback.WindowCallback

class LoginActivity : AppCompatActivity(), WindowCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun setWindowBackground(resId: Int) {
        logd(LoginActivity::class.java, "设置了WindowBackground")
        window.setBackgroundDrawableResource(resId)
    }
}
