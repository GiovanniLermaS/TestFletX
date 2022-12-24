package com.example.testfletx.view.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testfletx.databinding.ActivityMainBinding
import com.example.testfletx.view.main.adapter.VehiclesAdapter
import com.example.testfletx.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val homeActivityViewModel by viewModels<MainActivityViewModel>()

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        homeActivityViewModel.data.observe(this) {
            binding?.rvVehicles?.adapter = VehiclesAdapter(it)
        }
        homeActivityViewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        homeActivityViewModel.getVehicles()
    }
}