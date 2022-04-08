package com.kd.example.koin.activity

import android.os.Bundle
import com.kd.example.koin.R
import com.kd.example.koin.activity.base.BaseActivity
import com.kd.example.koin.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override val layoutResourceID: Int
        get() = R.layout.activity_main


    override fun initUI() {

    }

    override fun initObservers() {

    }
}