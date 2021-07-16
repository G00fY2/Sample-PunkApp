package com.g00fy2.punkapp.model.datasource.web

import com.g00fy2.punkapp.model.entities.web.BeerWebEntity
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject
import javax.inject.Named

class BeerDatasourceImpl @Inject constructor() : BeerDatasource {

  @Inject
  lateinit var httpClient: HttpClient

  @Inject
  @Named("BASE_URL")
  lateinit var baseUrl: String

  override suspend fun getAllBeers(): List<BeerWebEntity> = httpClient.get("$baseUrl/beers")

  override suspend fun getBeers(page: Int, perPage: Int): List<BeerWebEntity> = httpClient.get("$baseUrl/beers") {
    parameter("page", page)
    parameter("per_page", perPage)
  }

  override suspend fun getBeerByID(id: Int): BeerWebEntity = httpClient.get("$baseUrl/beers/$id")

  override suspend fun getRandomBeer(): BeerWebEntity = httpClient.get("$baseUrl/beers/random")
}