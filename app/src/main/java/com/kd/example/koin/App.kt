package com.kd.example.koin

import android.app.Application
import com.kd.example.koin.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createKoin()
    }

    private fun createKoin(){
        startKoin {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(listOf(ViewModelModule))
        }
    }

}