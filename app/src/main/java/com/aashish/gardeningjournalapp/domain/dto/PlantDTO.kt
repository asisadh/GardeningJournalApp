package com.aashish.gardeningjournalapp.domain.dto

import com.aashish.gardeningjournalapp.data.entity.Plant

data class PlantDTO(val id: Int?, val name: String, val type: String, val wateringFrequency: Int, val plantDate: String){

    companion object{
        fun toDTO(plant: Plant): PlantDTO = PlantDTO(plant.id, plant.name, plant.type, plant.wateringFrequency, plant.plantDate)
        fun toEntity(plant: PlantDTO): Plant = Plant(name = plant.name, type = plant.type, wateringFrequency = plant.wateringFrequency, plantDate = plant.plantDate)
    }

}