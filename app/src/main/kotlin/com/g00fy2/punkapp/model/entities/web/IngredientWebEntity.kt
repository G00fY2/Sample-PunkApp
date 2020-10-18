package com.g00fy2.punkapp.model.entities.web

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientWebEntity(
        val name: String,
        val amount: MeasurementWebEntity
)