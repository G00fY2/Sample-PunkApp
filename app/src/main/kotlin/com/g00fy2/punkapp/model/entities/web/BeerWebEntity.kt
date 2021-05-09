package com.g00fy2.punkapp.model.entities.web

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BeerWebEntity(
  val id: Int,
  val name: String,
  val tagline: String,
  @SerialName("first_brewed") val firstBrewed: String,
  val description: String,
  @SerialName("image_url") val imageUrl: String,
  val abv: Double,
  val ibu: Double?,
  @SerialName("target_fg") val targetFg: Double,
  @SerialName("target_og") val targetOg: Double,
  val ebc: Double?,
  val srm: Double?,
  val ph: Double?,
  @SerialName("attenuation_level") val attenuationLevel: Double,
  val volume: MeasurementWebEntity,
  @SerialName("boil_volume") val boilVolume: MeasurementWebEntity,
  val method: MethodWebEntity,
  val ingredients: Ingredients,
  @SerialName("food_pairing") val foodPairing: List<String>,
  @SerialName("brewers_tips") val brewersTips: String,
  @SerialName("contributed_by") val contributedBy: String,
)