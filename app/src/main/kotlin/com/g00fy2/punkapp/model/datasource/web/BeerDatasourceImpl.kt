package com.g00fy2.punkapp.model.datasource.web

import com.g00fy2.punkapp.model.entities.web.BeerWebEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class BeerDatasourceImpl @Inject constructor() : BeerDatasource {

  @Inject
  lateinit var httpClient: HttpClient

  override suspend fun getAllBeers(): List<BeerWebEntity> = httpClient.get("beers").body()

  override suspend fun getBeers(page: Int, perPage: Int): List<BeerWebEntity> = httpClient.get("beers") {
    parameter("page", page)
    parameter("per_page", perPage)
  }.body()

  override suspend fun getBeerByID(id: Int): BeerWebEntity = httpClient.get("beers/$id").body()

  override suspend fun getRandomBeer(): BeerWebEntity = httpClient.get("beers/random").body()
}