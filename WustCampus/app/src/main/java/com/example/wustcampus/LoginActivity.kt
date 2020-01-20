package com.example.wustcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.wustcampus.model.UserModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var userModel: UserModel
    private val isLoginObserver = Observer<Boolean> {

    }
    private val loginToast = Observer<String> {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userModel = ViewModelProviders.of(this).get(UserModel::class.java)
        userModel.isLoginSuccess.observe(this, isLoginObserver)
        userModel.loginToast.observe(this, loginToast)
        loginBtn.setOnClickListener {
            userModel.login(accountEt.text.toString(), passwordEt.text.toString())
        }
    }
}
