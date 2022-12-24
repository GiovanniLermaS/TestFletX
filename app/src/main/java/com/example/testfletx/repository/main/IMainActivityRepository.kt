package com.example.testfletx.repository.main

import com.example.testfletx.model.Data

interface IMainActivityRepository {
    fun getVehicles(
        response: (Data) -> Unit,
        error: (String?) -> Unit
    )
}