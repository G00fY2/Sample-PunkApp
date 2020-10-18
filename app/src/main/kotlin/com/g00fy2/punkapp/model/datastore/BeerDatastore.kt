package com.g00fy2.punkapp.model.datastore

import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.model.entities.web.BeerWebEntity
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerDatastore {

    suspend fun getAllBeers(): List<Beer>

    suspend fun getBeers(page: Int, perPage: Int): List<Beer>

    suspend fun getBeerByID(id: Int): Beer

    suspend fun getRandomBeer(): Beer
}