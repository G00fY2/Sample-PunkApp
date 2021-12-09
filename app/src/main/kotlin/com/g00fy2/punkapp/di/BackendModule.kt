package com.g00fy2.punkapp.di

import com.g00fy2.punkapp.BuildConfig
import com.g00fy2.punkapp.model.datasource.web.BeerDatasource
import com.g00fy2.punkapp.model.datasource.web.BeerDatasourceImpl
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import com.g00fy2.punkapp.model.datastore.BeerDatastoreImpl
import com.g00fy2.punkapp.model.transformer.BeerTransformer
import com.g00fy2.punkapp.model.transformer.BeerTransformerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Named

@Module(includes = [BackendStaticModule::class])
@InstallIn(SingletonComponent::class)
abstract class BackendModule {

  @Binds
  internal abstract fun provideBeerDatastore(beerDatastoreImpl: BeerDatastoreImpl): BeerDatastore

  @Binds
  internal abstract fun provideBeerTransformer(beerTransformerImpl: BeerTransformerImpl): BeerTransformer

  @Binds
  internal abstract fun provideBeerDatasource(beerDatasourceImpl: BeerDatasourceImpl): BeerDatasource
}

@Module
@InstallIn(SingletonComponent::class)
object BackendStaticModule {

  @Provides
  @Named("BASE_URL")
  fun provideBaseUrl(): String = BuildConfig.BASE_URL

  @Provides
  fun provideKtorHttpClient(): HttpClient {
    return HttpClient(OkHttp) {

      install(JsonFeature) {
        serializer = KotlinxSerializer(Json {
          ignoreUnknownKeys = true
          isLenient = true
        })
      }

      install(Logging) {
        logger = object : Logger {
          override fun log(message: String) {
            Timber.tag("Ktor")
            Timber.d(message)
          }
        }
        level = LogLevel.ALL
      }
    }
  }
}