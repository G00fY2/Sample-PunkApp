package com.g00fy2.punkapp.model.entities.web

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MethodWebEntity(
        val mash_temp: List<MashTempWebEntity>,
        val fermentation: FermentationWebEntity,
        val twist: String?,
)