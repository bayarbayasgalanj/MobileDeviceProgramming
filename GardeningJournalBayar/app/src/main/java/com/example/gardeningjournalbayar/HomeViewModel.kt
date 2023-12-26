package com.example.gardeningjournalbayar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.example.gardeningjournalbayar.data.Plant
import com.example.gardeningjournalbayar.data.PlantRepository

class HomeViewModel(private val plantRepository: PlantRepository) : ViewModel() {
    val allPlants: LiveData<List<Plant>> = plantRepository.allPlants
}