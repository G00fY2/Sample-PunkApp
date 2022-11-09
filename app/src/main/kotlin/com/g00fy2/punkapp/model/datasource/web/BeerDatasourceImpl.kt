package com.g00fy2.punkapp.model.datasource.web

import com.g00fy2.punkapp.model.entities.web.BeerWebEntity
import dagger.Lazy
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.util.*
import javax.inject.Inject

class BeerDatasourceImpl @Inject constructor(private val httpClient: Lazy<HttpClient>) : BeerDatasource {

  override suspend fun getAllBeers(): List<BeerWebEntity> = httpClient.get().get("beers").body()

  override suspend fun getBeers(page: Int, perPage: Int): List<BeerWebEntity> {
    return httpClient.get().get("beers") {
      parameter("page", page)
      parameter("per_page", perPage)
      parameter("test", Date().toString())
    }.body()
  }

  override suspend fun getBeerByID(id: Int): BeerWebEntity = httpClient.get().get("beers/$id").body()

  override suspend fun getRandomBeer(): BeerWebEntity = httpClient.get().get("beers/random").body()
}