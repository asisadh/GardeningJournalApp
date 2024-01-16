package com.aashish.gardeningjournalapp.ui.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aashish.gardeningjournalapp.domain.repository.PlantRepository
import com.aashish.gardeningjournalapp.domain.dto.PlantDTO
import kotlinx.coroutines.launch


public class PlantViewModel(private val application: Application): ViewModel() {

    private val repository: PlantRepository = PlantRepository(application)
    private val allPlants: LiveData<List<PlantDTO>> = repository.getAllPlants

    val getAllPlants: LiveData<List<PlantDTO>>
        get() = allPlants

    fun insertPlant(plant: PlantDTO) {
        viewModelScope.launch {
            repository.insertPlant(plant)
        }
    }

    suspend fun getPlant(byId: Int): LiveData<PlantDTO>{
        return repository.getPlantById(byId + 1)
    }
}
