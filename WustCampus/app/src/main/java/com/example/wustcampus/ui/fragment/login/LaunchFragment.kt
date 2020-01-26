package com.example.wustcampus.ui.fragment.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.commonlib.logd
import com.example.wustcampus.R
import com.example.wustcampus.ui.callback.WindowCallback
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LaunchFragment: Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is WindowCallback) {
            context.setWindowBackground(R.drawable.background_launch)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenStarted {
            delay(1500)
            findNavController().navigate(R.id.loginFragment)
        }
    }
}