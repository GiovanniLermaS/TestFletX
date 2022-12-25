package com.example.testfletx.view.main

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testfletx.databinding.ActivityMainBinding
import com.example.testfletx.model.Vehicle
import com.example.testfletx.utils.VEHICLE
import com.example.testfletx.view.main.adapter.VehiclesAdapter
import com.example.testfletx.view.main.interfaces.ClickVehicle
import com.example.testfletx.view.map.MapActivity
import com.example.testfletx.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ClickVehicle {

    private val homeActivityViewModel by viewModels<MainActivityViewModel>()

    private var binding: ActivityMainBinding? = null

    private val progress by lazy { ProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        progress.show()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        homeActivityViewModel.data.observe(this) {
            progress.dismiss()
            binding?.rvVehicles?.adapter = VehiclesAdapter(it, this)
        }
        homeActivityViewModel.error.observe(this) {
            progress.dismiss()
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        homeActivityViewModel.getVehicles()
    }

    override fun onVehicleSelected(vehicle: Vehicle) {
        val intent = Intent(this, MapActivity::class.java)
        intent.putExtra(VEHICLE, vehicle)
        startActivity(intent)
    }
}