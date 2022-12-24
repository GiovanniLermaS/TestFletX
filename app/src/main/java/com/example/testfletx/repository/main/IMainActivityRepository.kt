package com.example.testfletx.repository.main

import com.example.testfletx.model.Vehicles

interface IMainActivityRepository {
    fun getVehicles(
        response: (ArrayList<Vehicles>) -> Unit,
        error: (String?) -> Unit
    )
}