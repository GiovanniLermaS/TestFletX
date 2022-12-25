package com.example.testfletx.view.map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.testfletx.R
import com.example.testfletx.model.Vehicle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class InfoWindowVehicle(private val mContext: Context, private val vehicle: Vehicle?) :
    GoogleMap.InfoWindowAdapter {

    var mWindow: View = LayoutInflater.from(mContext).inflate(R.layout.info_window_vehicle, null)

    override fun getInfoContents(p0: Marker): View {
        setInfoWindowText()
        return mWindow
    }

    override fun getInfoWindow(p0: Marker): View {
        setInfoWindowText()
        return mWindow
    }

    private fun setInfoWindowText() {
        mWindow.findViewById<TextView>(R.id.plaque).text = vehicle?.plaque
        mWindow.findViewById<TextView>(R.id.driver_name).text =
            vehicle?.driver?.fullName ?: mContext.getString(R.string.noDriver)
        mWindow.findViewById<TextView>(R.id.trailer_plaque).text =
            if (vehicle?.trailer?.plaque == null) mContext.getString(R.string.noTrailer)
            else "Trailer: ${vehicle.trailer.plaque}"
        mWindow.findViewById<TextView>(R.id.is_available).text =
            if (vehicle?.status == 1) mContext.getString(R.string.available)
            else mContext.getString(R.string.noAvailable)
    }
}