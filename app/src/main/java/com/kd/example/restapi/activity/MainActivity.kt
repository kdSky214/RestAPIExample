package com.kd.example.restapi.activity

import android.os.Bundle
import android.widget.TextView
import com.kd.example.restapi.R
import com.kd.example.restapi.activity.base.BaseActivity
import com.kd.example.restapi.databinding.ActivityMainBinding
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
        viewModel.resultLiveData.observe(this) {
            binding.txtStatus.setText(it, TextView.BufferType.NORMAL)
        }

        viewModel.testRestfulGet()
    }
}