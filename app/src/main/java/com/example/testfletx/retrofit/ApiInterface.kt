package com.example.testfletx.retrofit

import com.example.testfletx.model.Vehicles
import com.example.testfletx.utils.GET_VEHICLES
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(GET_VEHICLES)
    fun getVehicles(): Call<ArrayList<Vehicles>>

}