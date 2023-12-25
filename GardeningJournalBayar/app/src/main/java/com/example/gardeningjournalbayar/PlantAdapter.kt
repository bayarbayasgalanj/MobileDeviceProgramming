package com.example.gardeningjournalbayar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningjournalbayar.data.Plant

class PlantAdapter(private val onClick: (Plant) -> Unit) : RecyclerView.Adapter<PlantAdapter.BlogViewHolder>() {
    private var plants = listOf<Plant>()

    class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.plant_name)
        val textViewType: TextView = view.findViewById(R.id.plant_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return BlogViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val currentItem = plants[position]
        holder.textViewName.text = currentItem.name
        holder.textViewType.text = currentItem.type

        holder.itemView.setOnClickListener {
            onClick(currentItem)
        }
    }

    override fun getItemCount() = plants.size

    fun setPlants(plants: List<Plant>) {
        this.plants = plants
        notifyDataSetChanged()
    }
}

