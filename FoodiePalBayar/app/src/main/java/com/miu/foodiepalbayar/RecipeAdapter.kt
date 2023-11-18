package com.miu.foodiepalbayar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView = view.findViewById(R.id.recipe_title)
        val imageView: ImageView = view.findViewById(R.id.recipe_image)
        val textViewCookingTime: TextView = view.findViewById(R.id.recipe_cooking_time)
        val ratingBar: RatingBar = view.findViewById(R.id.recipe_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = recipes[position]
        holder.textViewTitle.text = currentItem.title
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textViewCookingTime.text = currentItem.cookingTime
        holder.ratingBar.rating = currentItem.rating
    }

    override fun getItemCount() = recipes.size
}
