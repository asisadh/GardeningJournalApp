package com.aashish.gardeningjournalapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aashish.gardeningjournalapp.data.entity.Plant

@Dao
interface PlantDao {
    @Insert
    suspend fun addPlant(plant: Plant)
    @Query("SELECT * FROM Plant")
    fun getAllPlants(): LiveData<List<Plant>>

    @Query("SELECT * FROM Plant WHERE id = :plantId")
    fun getPlantById(plantId: Long): LiveData<Plant>
}