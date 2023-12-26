package com.bright.fragdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bright.fragdemo.data.Plant
import com.bright.fragdemo.data.PlantRepository

class FirstFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var plantRepository: PlantRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.blogs_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val pls = listOf<Plant>()
        // Initialize PlantAdapter
        plantAdapter = PlantAdapter() // Initialize with an empty list

        // Initialize PlantRepository
        plantRepository = PlantRepository(requireActivity().application)

        // Set the adapter to RecyclerView
        recyclerView.adapter = plantAdapter

        // Observe LiveData from Repository
        plantRepository.allPlants.observe(viewLifecycleOwner, { plants ->
            // Update the adapter with the new list of plants
            plantAdapter.setPlants(plants)
        })

        return view
    }
}

