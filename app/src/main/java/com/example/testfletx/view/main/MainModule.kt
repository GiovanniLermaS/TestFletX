package com.example.testfletx.view.main

import com.example.testfletx.repository.main.IMainActivityRepository
import com.example.testfletx.repository.main.MainActivityRepository
import com.example.testfletx.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideAboutRepository(apiInterface: ApiInterface): IMainActivityRepository {
        return MainActivityRepository(apiInterface)
    }
}