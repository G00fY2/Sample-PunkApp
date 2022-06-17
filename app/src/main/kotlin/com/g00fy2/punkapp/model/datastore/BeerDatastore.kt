package com.g00fy2.punkapp.model.datastore

import com.g00fy2.punkapp.model.entities.domain.Beer
import kotlinx.coroutines.flow.Flow

interface BeerDatastore {

  fun getAllBeers(): Flow<List<Beer>>

  fun getBeers(page: Int, perPage: Int): Flow<List<Beer>>

  fun getBeerByID(id: Int): Flow<Beer>

  fun getRandomBeer(): Flow<Beer>
}