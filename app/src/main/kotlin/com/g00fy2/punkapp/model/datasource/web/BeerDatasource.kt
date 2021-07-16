package com.g00fy2.punkapp.model.datasource.web

import com.g00fy2.punkapp.model.entities.web.BeerWebEntity

interface BeerDatasource {

  suspend fun getAllBeers(): List<BeerWebEntity>

  suspend fun getBeers(page: Int, perPage: Int): List<BeerWebEntity>

  suspend fun getBeerByID(id: Int): BeerWebEntity

  suspend fun getRandomBeer(): BeerWebEntity
}