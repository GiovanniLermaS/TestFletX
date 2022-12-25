package com.example.testfletx.view.map

import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testfletx.R
import com.example.testfletx.databinding.ActivityMapBinding
import com.example.testfletx.model.Vehicle
import com.example.testfletx.utils.VEHICLE
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var binding: ActivityMapBinding? = null

    private lateinit var mMap: GoogleMap

    private val progress by lazy { ProgressDialog(this) }

    private val vehicle by lazy {
        if (Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra(VEHICLE, Vehicle::class.java)
        } else {
            intent.getSerializableExtra(VEHICLE) as Vehicle
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        progress.show()
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        vehicle?.lonLat?.let {
            val split = it.split(" ")
            val long = split[1].replace("(", "").toDouble()
            val lat = split[2].replace(")", "").toDouble()

            val latLng = LatLng(lat, long)
            mMap.addMarker(
                MarkerOptions()
                    .position(latLng)
            )
            mMap.setInfoWindowAdapter(InfoWindowVehicle(this, vehicle))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12f))
        }
        progress.dismiss()
    }
}