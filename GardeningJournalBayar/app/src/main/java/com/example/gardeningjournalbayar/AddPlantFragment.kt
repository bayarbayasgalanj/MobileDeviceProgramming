package com.example.gardeningjournalbayar

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gardeningjournalbayar.data.Plant
import com.example.gardeningjournalbayar.data.PlantRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class AddPlantFragment : Fragment() {
    private lateinit var plantRepository: PlantRepository
    private lateinit var editName: EditText
    private lateinit var editType: EditText
    private lateinit var editWateringFrequency: EditText
    private lateinit var editPlantingDate: EditText
    private lateinit var buttonSave: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.adding_plant, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editName = view.findViewById(R.id.editName)
        editType = view.findViewById(R.id.editType)
        editWateringFrequency = view.findViewById(R.id.editWateringFrequency)
        editPlantingDate = view.findViewById(R.id.editPlantingDate)
        editPlantingDate.setOnClickListener {
            showDatePickerDialog()
        }
        buttonSave = view.findViewById(R.id.button_save)
        plantRepository = PlantRepository(requireActivity().application)
        buttonSave.setOnClickListener {
            if (areAllFieldsFilled()) {
                savePlant()
            } else {
                Toast.makeText(context, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun areAllFieldsFilled(): Boolean {
        if (editName.text.isEmpty() ||
            editType.text.isEmpty() ||
            editWateringFrequency.text.isEmpty() ||
            editPlantingDate.text.isEmpty()) {
            return false
        }
        return true
    }
    private fun savePlant() {
        val name = editName.text.toString()
        val type = editType.text.toString()
        val wateringFrequency = editWateringFrequency.text.toString().toIntOrNull() ?: 0
        val plantingDate = editPlantingDate.text.toString()
        val newPlant = Plant(name = name, type = type, wateringFrequency = wateringFrequency, plantingDate = plantingDate)
        requireActivity().lifecycleScope.launch(Dispatchers.IO) {
            plantRepository.insert(newPlant)
            launch(Dispatchers.Main) {
                navigateToHomeFragment()
            }
        }

    }
    private fun navigateToHomeFragment() {
        val action = AddPlantFragmentDirections.actionAddPlantToHomeFragment()
        findNavController().navigate(action)
    }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "${selectedMonth + 1}/$selectedDay/$selectedYear"
            editPlantingDate.setText(selectedDate)
        }, year, month, day).show()
    }
}
