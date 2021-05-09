package com.g00fy2.punkapp.model.entities.web

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MethodWebEntity(
  @SerialName("mash_temp") val mashTemp: List<MashTempWebEntity>,
  val fermentation: FermentationWebEntity,
  val twist: String?
)