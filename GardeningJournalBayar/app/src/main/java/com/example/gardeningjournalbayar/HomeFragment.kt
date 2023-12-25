package com.example.gardeningjournalbayar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningjournalbayar.data.PlantRepository

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var plantRepository: PlantRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.blogs_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        // Initialize PlantAdapter with click listener
        plantAdapter = PlantAdapter { plant ->
            val action = HomeFragmentDirections.actionHomeToPlantDetailsFragment(plantId = plant.id)
            findNavController().navigate(action)
        }

        recyclerView.adapter = plantAdapter

        // Initialize PlantRepository and observe LiveData
        plantRepository = PlantRepository(requireActivity().application)
        plantRepository.allPlants.observe(viewLifecycleOwner) { plants ->
            plantAdapter.setPlants(plants)
        }

        return view
    }
}

