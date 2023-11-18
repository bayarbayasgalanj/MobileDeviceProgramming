package com.miu.foodiepalbayar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipes: List<Recipe>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        recyclerView = view.findViewById(R.id.recipes_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        // Sample data
        recipes = listOf(
            Recipe("Chocolate Cake", R.drawable.chocolate_cake, "45 mins", 4.5f),
            Recipe("Pasta", R.drawable.pasta, "30 mins", 4.0f)
            // Add more recipes here
        )

        recipeAdapter = RecipeAdapter(recipes)
        recyclerView.adapter = recipeAdapter
        return view
    }
}
