package com.miu.foodiepalbayar

data class Recipe(
    val title: String,
    val imageResource: Int, // Reference to drawable
    val cookingTime: String,
    val rating: Float
)
