package com.g00fy2.punkapp.model.datastore

import com.g00fy2.punkapp.model.datasource.api.BeerDatasource
import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.model.transformer.BeerTransformer
import javax.inject.Inject

class BeerDatastoreImpl @Inject constructor() : BeerDatastore {

    @Inject
    lateinit var beerDatasource: BeerDatasource

    @Inject
    lateinit var beerTransformer: BeerTransformer

    override suspend fun getAllBeers(): List<Beer> {
        return beerDatasource.getAllBeers().map { beerTransformer.toModel(it) }
    }

    override suspend fun getBeers(page: Int, perPage: Int): List<Beer> {
        return beerDatasource.getBeers(page, perPage).map { beerTransformer.toModel(it) }
    }

    override suspend fun getBeerByID(id: Int): Beer {
        return beerDatasource.getBeerByID(id).let { beerTransformer.toModel(it) }
    }

    override suspend fun getRandomBeer(): Beer {
        return beerDatasource.getRandomBeer().let { beerTransformer.toModel(it) }
    }
}