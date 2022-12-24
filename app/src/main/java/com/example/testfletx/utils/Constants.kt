package com.example.testfletx.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

const val BASE_URL = "http://st.fletx.co:3000/"
const val GET_VEHICLES = "people/holder_vehicles/2282.json"

fun hasNetwork(context: Context): Boolean? {
    var isConnected: Boolean? = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}