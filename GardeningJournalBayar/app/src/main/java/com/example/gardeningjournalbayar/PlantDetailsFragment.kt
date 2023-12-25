package com.example.gardeningjournalbayar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class PlantDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_plant_details, container, false)

        val plantId = arguments?.getInt("plantId")
        // Use plantId to load plant details

        return view
    }

    // Additional functions and logic for displaying plant details
}
