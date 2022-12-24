package com.example.testfletx.repository.main

import com.example.testfletx.model.Data
import com.example.testfletx.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityRetainedScoped
class MainActivityRepository(private val apiInterface: ApiInterface) : IMainActivityRepository {

    override fun getVehicles(response: (Data) -> Unit, error: (String?) -> Unit) {
        val call = apiInterface.getVehicles()
        call.enqueue(object : Callback<Data> {
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                response.body()?.let { response(it) }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                t.message?.let { error(it) }
            }

        })
    }
}