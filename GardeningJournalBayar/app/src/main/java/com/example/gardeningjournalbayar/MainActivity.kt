package com.example.gardeningjournalbayar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.gardeningjournalbayar.data.Plant
import com.example.gardeningjournalbayar.data.PlantRepository
import com.example.gardeningjournalbayar.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        supportActionBar?.title = "Home"
        insertSamplePlants()
        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp() || super.onSupportNavigateUp()
    }
    @SuppressLint("SuspiciousIndentation")
    private fun insertSamplePlants() {
        val plantRepository = PlantRepository(application)
        lifecycleScope.launch(Dispatchers.IO) {
            if (plantRepository.isDatabaseEmpty()) {
                val samplePlants = listOf(
                    Plant(name = "name1", type = "Type1", wateringFrequency=12,  plantingDate= "date1"),
                    Plant(name = "name2", type = "Type2", wateringFrequency=13,  plantingDate= "date2"),
                    Plant(name = "name3", type = "Type3", wateringFrequency=14,  plantingDate= "date3")
                )
                samplePlants.forEach { plant ->
                    plantRepository.insert(plant)
                }
            }
        }
    }
}
