package com.aashish.gardeningjournalapp.domain.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.aashish.gardeningjournalapp.data.dao.PlantDao
import com.aashish.gardeningjournalapp.data.repository.GardeningDatabase
import com.aashish.gardeningjournalapp.domain.dto.PlantDTO


class PlantRepository(application: Application) {

    private val plantDao: PlantDao
    private val plants: LiveData<List<PlantDTO>>

    init {
        val db: GardeningDatabase = GardeningDatabase(application)
        plantDao = db.getPlantDao()
        plants = db.getPlantDao().getAllPlants().map { entities -> entities.map { entity -> PlantDTO.toDTO(entity) } }
    }

    suspend fun insertPlant(plant: PlantDTO) {
        plantDao.addPlant(PlantDTO.toEntity(plant))
    }

    suspend fun getPlantById(id: Int): LiveData<PlantDTO>{
        return  plantDao.getPlantById(id.toLong()).map { entity -> PlantDTO.toDTO(entity) }
    }

    val getAllPlants: LiveData<List<PlantDTO>>
        get() = plants
}
