package com.kd.example.koin.di

import com.kd.example.koin.activity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module{

    viewModel{MainViewModel()}
}