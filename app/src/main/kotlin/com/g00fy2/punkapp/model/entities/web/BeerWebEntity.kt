package com.g00fy2.punkapp.model.entities.web

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BeerWebEntity(
  val id: Int,
  val name: String,
  val tagline: String,
  @Json(name = "first_brewed") val firstBrewed: String,
  val description: String,
  @Json(name = "image_url") val imageUrl: String,
  val abv: Double,
  val ibu: Double?,
  @Json(name = "target_fg") val targetFg: Double,
  @Json(name = "target_og") val targetOg: Double,
  val ebc: Double?,
  val srm: Double?,
  val ph: Double?,
  @Json(name = "attenuation_level") val attenuationLevel: Double,
  val volume: MeasurementWebEntity,
  @Json(name = "boil_volume") val boilVolume: MeasurementWebEntity,
  val method: MethodWebEntity,
  val ingredients: Ingredients,
  @Json(name = "food_pairing") val foodPairing: List<String>,
  @Json(name = "brewers_tips") val brewersTips: String,
  @Json(name = "contributed_by") val contributedBy: String,
)