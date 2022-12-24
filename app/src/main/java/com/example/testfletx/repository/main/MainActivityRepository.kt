package com.example.testfletx.repository.main

import com.example.testfletx.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
class MainActivityRepository(private val apiInterface: ApiInterface) : IMainActivityRepository {

}