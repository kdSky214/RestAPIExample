package com.kd.example.restapi

import android.app.Application
import com.google.firebase.FirebaseApp
import com.kd.example.restapi.di.NetworkModule
import com.kd.example.restapi.di.RepositoryModule
import com.kd.example.restapi.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    companion object{
        const val retrofitUrl = "http://192.168.0.101:20335"
    }
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.tag("[RestAPI TEST]")
        FirebaseApp.initializeApp(this)

        createKoin()
    }

    private fun createKoin(){
        startKoin {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(listOf(NetworkModule,  RepositoryModule, ViewModelModule))
        }
    }

}