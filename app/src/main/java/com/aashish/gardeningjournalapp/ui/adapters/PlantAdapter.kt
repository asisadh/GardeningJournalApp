package com.aashish.gardeningjournalapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aashish.gardeningjournalapp.R
import com.aashish.gardeningjournalapp.Utils
import com.aashish.gardeningjournalapp.domain.dto.PlantDTO

class PlantAdapter(val onClick: (Int) -> Unit) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private var plantList: List<PlantDTO> = ArrayList<PlantDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val currentPlant = plantList[position]
        holder.plantNameTextView.text = currentPlant.name
        holder.typeOfPlantTextView.text = currentPlant.type
        holder.frequencyTextView.text = "Water Frequency: ${currentPlant.wateringFrequency}"
        holder.plantDate.text = currentPlant.plantDate
        holder.imageView.setImageResource(Utils.mapIdToImageName(currentPlant.id ?: 0))
        holder.view.setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun setPlants(plants: List<PlantDTO>) {
        this.plantList = plants
        notifyDataSetChanged()
    }

    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.backgroundImageView)
        val plantNameTextView: TextView = itemView.findViewById(R.id.plantNameTextView)
        val typeOfPlantTextView: TextView = itemView.findViewById(R.id.typeOfPlantTextView)
        val frequencyTextView: TextView = itemView.findViewById(R.id.waterFrequencyTextView)
        val plantDate: TextView = itemView.findViewById(R.id.plantingDateTextView)
        val view: View = itemView.findViewById(R.id.plantView)
    }
}