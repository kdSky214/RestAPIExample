package com.kd.example.restapi.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kd.example.restapi.repository.RestfulRepository
import com.kd.example.restapi.util.observe
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(private val restService:RestfulRepository) : ViewModel() {

    var resultLiveData:MutableLiveData<String> = MutableLiveData()
    fun testRestfulGet(){
        Timber.e("testRestfulGet")
        viewModelScope.launch {
            restService.getTest().observe(
                onSuccess = {
                    Timber.e("testRestfulGet onSuccess(${it})")
                    resultLiveData.value = "$it"
                }, onError = {
                    Timber.e("testRestfulGet onError(${it})")
                    resultLiveData.value = "$it"
                })
        }
    }
}