package com.example.testfletx.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testfletx.model.Vehicles
import com.example.testfletx.repository.main.IMainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepository: IMainActivityRepository) :
    ViewModel() {

    private val _vehicles = MutableLiveData<Vehicles>()
    val vehicles: LiveData<Vehicles> = _vehicles


    fun getVehicles(
        response: (ArrayList<Vehicles>) -> Unit,
        error: (String?) -> Unit
    ) {
        mainActivityRepository.getVehicles({ response(it) }, { error(it) })
    }
}