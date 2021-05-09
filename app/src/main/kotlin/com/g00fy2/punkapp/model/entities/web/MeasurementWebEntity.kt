package com.g00fy2.punkapp.model.entities.web

import kotlinx.serialization.Serializable

@Serializable
data class MeasurementWebEntity(val value: Double, val unit: String)