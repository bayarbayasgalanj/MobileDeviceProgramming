package com.example.gardeningjournalbayar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface PlantDao {
    @Query("SELECT * FROM plants")
    fun getAllPlants(): LiveData<List<Plant>>
    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlantById(plantId: Int): LiveData<Plant>
    @Insert
    fun addPlant(plant: Plant)
    @Query("SELECT COUNT(*) FROM plants")
    suspend fun getPlantCount(): Int
}