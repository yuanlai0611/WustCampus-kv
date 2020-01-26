package com.example.wustcampus.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.wustcampus.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNavigationView(bottomNavigationView, (hostFragment as NavHostFragment).navController)
    }

    companion object {
        fun launch(ctx: Context) {
            ctx.startActivity(Intent(ctx, MainActivity::class.java))
            if (ctx is Activity) {
                ctx.finish()
            }
        }
    }

    private fun initBottomNavigationView(view: BottomNavigationView, controller: NavController) {
        view.setupWithNavController(controller)
    }
}
