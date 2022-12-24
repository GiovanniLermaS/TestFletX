package com.example.testfletx.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testfletx.R
import com.example.testfletx.databinding.ViewVehiclesBinding
import com.example.testfletx.model.Data

class VehiclesAdapter(private val data: Data) :
    RecyclerView.Adapter<VehiclesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewVehiclesBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_vehicles, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val vehicle = data.vehicle[position]
        Glide.with(holder.itemView)
            .load(vehicle.frontVehicle.url?.replace("prueba", "staging"))
            .into(holder.binding.photo)
        holder.binding.plaque.text = vehicle.plaque
        holder.binding.driverName.text =
            vehicle.driver?.fullName ?: context.getString(R.string.noDriver)
        holder.binding.trailerPlaque.text =
            if (vehicle.trailer?.plaque == null) context.getString(R.string.noTrailer)
            else "Trailer: ${vehicle.trailer.plaque}"
        holder.binding.isAvailable.text =
            if (vehicle.status == 1) context.getString(R.string.available)
            else context.getString(R.string.noAvailable)
    }

    override fun getItemCount() = data.vehicle.size
}