package com.example.gardeningjournalbayar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gardeningjournalbayar.data.Plant
import com.example.gardeningjournalbayar.data.PlantRepository

class PlantDetailsFragment : Fragment() {

    private lateinit var plantRepository: PlantRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_plant_details, container, false)

        plantRepository = PlantRepository(requireActivity().application)
        val plantId = arguments?.getInt("plantId") ?: -1
        if (plantId != -1) {
            loadPlantDetails(plantId, view)
        }
        return view
    }

    private fun loadPlantDetails(plantId: Int, view: View) {
        plantRepository.getPlantById(plantId).observe(viewLifecycleOwner) { plant ->
            updateUIWithPlantDetails(plant, view)
        }
    }
    private fun updateUIWithPlantDetails(plant: Plant, view: View) {
        view.findViewById<TextView>(R.id.textViewPlantId).text = "ID: ${plant.id}"
        view.findViewById<TextView>(R.id.textViewPlantName).text = "Plant Name: ${plant.name}"
        view.findViewById<TextView>(R.id.textViewPlantType).text = "Type: ${plant.type}"
        view.findViewById<TextView>(R.id.textViewWateringFrequency).text = "Watering Frequency: ${plant.wateringFrequency} days"
        view.findViewById<TextView>(R.id.textViewPlantingDate).text = "Planting Date: ${plant.plantingDate}"
    }
}
