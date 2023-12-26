package com.example.gardeningjournalbayar.data

import android.app.Application
import androidx.lifecycle.LiveData

class PlantRepository(application: Application) {
    private val plantDao: PlantDao
    val allPlants: LiveData<List<Plant>>
    init {
        val database = PlantDatabase.getDatabase(application)
        plantDao = database.plantDao()
        allPlants = plantDao.getAllPlants()
    }
    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantDao.getPlantById(plantId)
    }
    fun insert(plant: Plant) {
        plantDao.addPlant(plant)
    }
    suspend fun isDatabaseEmpty(): Boolean {
        return plantDao.getPlantCount() == 0
    }
}