package com.example.testfletx.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testfletx.model.Data
import com.example.testfletx.repository.main.IMainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepository: IMainActivityRepository) :
    ViewModel() {

    private val _vehicles = MutableLiveData<Data>()
    val data: LiveData<Data> = _vehicles

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getVehicles() {
        mainActivityRepository.getVehicles({
            _vehicles.postValue(it)
        }, {
            _error.postValue(it)
        })
    }
}