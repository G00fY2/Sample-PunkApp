package com.g00fy2.punkapp.model.datasource.api

import com.g00fy2.punkapp.model.entities.web.BeerWebEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerDatasource {

    @GET("beers")
    suspend fun getAllBeers(): List<BeerWebEntity>

    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int, @Query("per_page") perPage: Int): List<BeerWebEntity>

    @GET("beers/{id}")
    suspend fun getBeerByID(@Path("id") id: Int): BeerWebEntity

    @GET("beers/random")
    suspend fun getRandomBeer(): BeerWebEntity
}