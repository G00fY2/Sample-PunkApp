package com.g00fy2.punkapp.model.datastore

import com.g00fy2.punkapp.model.entities.domain.Beer
import kotlinx.coroutines.flow.Flow

interface BeerDatastore {

  suspend fun getAllBeers(): Flow<List<Beer>>

  suspend fun getBeers(page: Int, perPage: Int): Flow<List<Beer>>

  suspend fun getBeerByID(id: Int): Flow<Beer>

  suspend fun getRandomBeer(): Flow<Beer>
}