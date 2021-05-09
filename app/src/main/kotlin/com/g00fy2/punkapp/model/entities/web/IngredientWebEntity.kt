package com.g00fy2.punkapp.model.entities.web

import kotlinx.serialization.Serializable

@Serializable
data class IngredientWebEntity(val name: String, val amount: MeasurementWebEntity)