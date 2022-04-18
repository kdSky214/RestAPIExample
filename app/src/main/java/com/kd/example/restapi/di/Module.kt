package com.kd.example.restapi.di

import com.google.gson.GsonBuilder
import com.kd.example.restapi.App
import com.kd.example.restapi.activity.MainViewModel
import com.kd.example.restapi.network.RestServiceInterface
import com.kd.example.restapi.repository.RestfulRepository
import com.kd.example.restapi.repository.RestfulRepositoryImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val NetworkModule = module {
    single { createRetrofit(App.retrofitUrl) }
    single { createRestService(get()) }
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
//    single<RestfulRepository> {  createRetrofitRepository(get()) }
}
fun createRetrofitRepository(restService:RestServiceInterface) = RestfulRepositoryImp(restService)
fun createRestService(retrofit: Retrofit): RestServiceInterface = retrofit.create(RestServiceInterface::class.java)

val ViewModelModule = module{
    single<RestfulRepository> {  createRetrofitRepository(get()) }
    viewModel{MainViewModel(get())}
}


