package com.g00fy2.punkapp.model.datastore

import com.g00fy2.punkapp.model.entities.domain.Beer

interface BeerDatastore {

  suspend fun getAllBeers(): List<Beer>

  suspend fun getBeers(page: Int, perPage: Int): List<Beer>

  suspend fun getBeerByID(id: Int): Beer

  suspend fun getRandomBeer(): Beer
}