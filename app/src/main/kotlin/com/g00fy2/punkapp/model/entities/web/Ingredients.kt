package com.g00fy2.punkapp.model.entities.web

import kotlinx.serialization.Serializable

@Serializable
data class Ingredients(val malt: List<IngredientWebEntity>, val hops: List<IngredientWebEntity>, val yeast: String)