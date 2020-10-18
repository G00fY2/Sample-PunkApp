package com.g00fy2.punkapp.model.entities.web

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredients(
        val malt: List<IngredientWebEntity>,
        val hops: List<IngredientWebEntity>,
        val yeast: String,
)