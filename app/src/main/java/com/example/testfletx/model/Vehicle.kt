package com.example.testfletx.model

import com.google.gson.annotations.SerializedName

class Vehicle {

    @SerializedName("front_vehicle")
    val frontVehicle = FrontVehicle()

    @SerializedName("placa")
    val plaque: String? = null

    @SerializedName("status")
    val status: Int = 0

    @SerializedName("driver")
    val driver: Driver? = null

    @SerializedName("trailer")
    val trailer: Trailer? = null

    @SerializedName("lonlat")
    val lonLat: String? = null
}