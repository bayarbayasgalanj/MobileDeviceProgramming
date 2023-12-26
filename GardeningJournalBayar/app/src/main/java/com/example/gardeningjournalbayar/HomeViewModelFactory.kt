package com.example.gardeningjournalbayar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gardeningjournalbayar.data.PlantRepository

class HomeViewModelFactory(private val plantRepository: PlantRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(plantRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}