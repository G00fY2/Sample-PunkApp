package com.g00fy2.punkapp.model.entities.web

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MethodWebEntity(
  @Json(name = "mash_temp") val mashTemp: List<MashTempWebEntity>,
  val fermentation: FermentationWebEntity,
  val twist: String?,
)