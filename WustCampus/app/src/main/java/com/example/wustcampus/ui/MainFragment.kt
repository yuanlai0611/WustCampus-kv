package com.example.wustcampus.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.wustcampus.R
import com.example.wustcampus.model.MainModel

class MainFragment: Fragment() {
    private lateinit var mainModel: MainModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainModel = ViewModelProviders.of(this).get(MainModel::class.java)
        mainModel.fetchCourse("2017-2018-1")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}