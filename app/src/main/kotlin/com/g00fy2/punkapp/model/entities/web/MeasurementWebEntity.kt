package com.g00fy2.punkapp.model.entities.web

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeasurementWebEntity(
  val value: Double,
  val unit: String,
)