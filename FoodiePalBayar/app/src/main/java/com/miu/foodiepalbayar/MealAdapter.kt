package com.miu.foodiepalbayar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MealAdapter(private val meals: List<Meal>) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    class MealViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewWeekday: TextView = view.findViewById(R.id.meal_weekday)
        val textViewMealplan: TextView = view.findViewById(R.id.meal_mealplan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_meal_plan, parent, false)
        return MealViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val currentItem = meals[position]
        holder.textViewWeekday.text = currentItem.weekday
        holder.textViewMealplan.text = currentItem.mealplan
    }

    override fun getItemCount() = meals.size
}
