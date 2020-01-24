package com.example.wustcampus.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.wustcampus.R
import com.example.wustcampus.model.UserModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var mUserModel: UserModel
    // 控制跳转
    private val isJumpToMainFragmentObserver = Observer<Boolean> {
        if (it) {
            findNavController().navigate(R.id.mainFragment)
        }
    }
    private val backPressedCallback = object: OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            findNavController().popBackStack()
        }
    }
    // 显示登录结果的提示
    private val loginToastObserver = Observer<String> {
        Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mUserModel = ViewModelProviders.of(this).get(UserModel::class.java)
        mUserModel.isJumpToMainFragment.observe(this, isJumpToMainFragmentObserver)
        mUserModel.loginToast.observe(this, loginToastObserver)
        mUserModel.checkIsLogin()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginBtn.setOnClickListener {
            mUserModel.login(accountEt.text.toString(), passwordEt.text.toString())
        }
        activity?.onBackPressedDispatcher?.addCallback(this, backPressedCallback)
    }



}