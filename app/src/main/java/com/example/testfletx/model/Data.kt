package com.example.testfletx.model

import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("data")
    val vehicle = ArrayList<Vehicle>()
}