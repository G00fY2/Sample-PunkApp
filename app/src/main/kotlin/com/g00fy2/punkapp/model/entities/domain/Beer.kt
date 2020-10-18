package com.g00fy2.punkapp.model.entities.domain

data class Beer(
        val id: Int,
        val name: String,
        val tagline: String,
        val first_brewed: String,
        val description: String,
        val image_url: String,
)