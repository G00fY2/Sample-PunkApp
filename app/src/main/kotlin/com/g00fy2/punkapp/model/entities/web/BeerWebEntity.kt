package com.g00fy2.punkapp.model.entities.web

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BeerWebEntity(
        val id: Int,
        val name: String,
        val tagline: String,
        val first_brewed: String,
        val description: String,
        val image_url: String,
        val abv: Double,
        val ibu: Double?,
        val target_fg: Double,
        val target_og: Double,
        val ebc: Double?,
        val srm: Double?,
        val ph: Double?,
        val attenuation_level: Double,
        val volume: MeasurementWebEntity,
        val boil_volume: MeasurementWebEntity,
        val method: MethodWebEntity,
        val ingredients: Ingredients,
        val food_pairing: List<String>,
        val brewers_tips: String,
        val contributed_by: String,
)