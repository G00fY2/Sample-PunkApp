package com.g00fy2.punkapp.model.entities.web

import kotlinx.serialization.Serializable

@Serializable
data class MashTempWebEntity(val temp: MeasurementWebEntity, val duration: Int?)