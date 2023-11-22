package com.miu.foodiepalbayar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MealFragment : Fragment(), AddDialogFragment.AddMealListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mealAdapter: MealAdapter
    private val meals: MutableList<Meal> = mutableListOf(
        Meal("Monday", "Breakfast: Bread & Butter"),
        Meal("Tuesday", "Lunch: Pizza")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_meals, container, false)
        recyclerView = view.findViewById(R.id.meals_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        // Sample data
        mealAdapter = MealAdapter(meals)
        recyclerView.adapter = mealAdapter
        return view
    }

    override fun onMealAdded(meal: Meal) {
        meals.add(meal)
        mealAdapter.notifyItemInserted(meals.size - 1)
    }
}
