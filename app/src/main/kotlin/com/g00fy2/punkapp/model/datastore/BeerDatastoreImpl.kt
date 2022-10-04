package com.g00fy2.punkapp.model.datastore

import com.g00fy2.punkapp.di.Dispatcher
import com.g00fy2.punkapp.di.PunkDispatchers.IO
import com.g00fy2.punkapp.model.datasource.web.BeerDatasource
import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.model.transformer.BeerTransformer
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BeerDatastoreImpl @Inject constructor(
  private val beerDatasource: BeerDatasource,
  private val beerTransformer: BeerTransformer,
  @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
) : BeerDatastore {

  override fun getAllBeers(): Flow<List<Beer>> {
    return flow {
      val beerList = beerDatasource.getAllBeers().map { beerTransformer.toModel(it) }
      emit(beerList)
    }.flowOn(ioDispatcher)
  }

  override fun getBeers(page: Int, perPage: Int): Flow<List<Beer>> {
    return flow {
      val beerList = beerDatasource.getBeers(page, perPage).map { beerTransformer.toModel(it) }
      emit(beerList)
    }.flowOn(ioDispatcher)
  }

  override fun getBeerByID(id: Int): Flow<Beer> {
    return flow {
      val beer = beerDatasource.getBeerByID(id).let { beerTransformer.toModel(it) }
      emit(beer)
    }.flowOn(ioDispatcher)
  }

  override fun getRandomBeer(): Flow<Beer> {
    return flow {
      val beer = beerDatasource.getRandomBeer().let { beerTransformer.toModel(it) }
      emit(beer)
    }.flowOn(ioDispatcher)
  }
}