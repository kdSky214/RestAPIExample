package com.kd.example.restapi.di

import com.google.gson.GsonBuilder
import com.kd.example.restapi.App
import com.kd.example.restapi.activity.MainViewModel
import com.kd.example.restapi.repository.RetrofitRepository
import com.kd.example.restapi.repository.RetrofitRepositoryImp
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val NetworkModule = module {
    single { createRetrofit(App.retrofitUrl) }

}

fun createRetrofit(baseUrl:String):Retrofit{
    val gson = GsonBuilder()
        .setLenient()
        .create()
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}
val RepositoryModule = module {
    single<RetrofitRepository> {  createRetrofitRepository(get()) }
}

fun createRetrofitRepository(retrofit: Retrofit) = RetrofitRepositoryImp(retrofit)
val ViewModelModule = module{
    viewModel{MainViewModel()}
}


