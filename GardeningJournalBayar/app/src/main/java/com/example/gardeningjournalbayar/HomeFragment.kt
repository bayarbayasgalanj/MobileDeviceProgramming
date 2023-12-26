package com.example.gardeningjournalbayar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningjournalbayar.data.PlantRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var plantRepository: PlantRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.blogs_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        plantAdapter = PlantAdapter { plant ->
            val action = HomeFragmentDirections.actionHomeToPlantDetailsFragment(plantId = plant.id)
            findNavController().navigate(action)
        }
        recyclerView.adapter = plantAdapter
        plantRepository = PlantRepository(requireActivity().application)
        plantRepository.allPlants.observe(viewLifecycleOwner) { plants ->
            plantAdapter.setPlants(plants)
        }
        val addButton: FloatingActionButton = view.findViewById(R.id.button_add)
        addButton.setOnClickListener {
            navigateToAddPlantFragment()
        }
        return view
    }
    private fun navigateToAddPlantFragment() {
        val action = HomeFragmentDirections.actionAddPlant()
        findNavController().navigate(action)
    }
}

