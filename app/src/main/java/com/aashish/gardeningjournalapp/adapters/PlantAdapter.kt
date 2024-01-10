package com.aashish.gardeningjournalapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aashish.gardeningjournalapp.R
import com.aashish.gardeningjournalapp.model.Plant

class PlantAdapter(private val plantList: List<Plant>) :
    RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val currentPlant = plantList[position]
//        holder.plantNameTextView.text = currentPlant.name
//        holder.typeOfPlantTextView.text = currentPlant.type
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val plantNameTextView: TextView = itemView.findViewById(R.id.plantNameTextView)
//        val typeOfPlantTextView: TextView = itemView.findViewById(R.id.typeOfPlantTextView)
    }
}