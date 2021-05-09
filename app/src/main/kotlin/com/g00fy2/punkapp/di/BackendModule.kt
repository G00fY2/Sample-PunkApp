package com.g00fy2.punkapp.di

import com.g00fy2.punkapp.BuildConfig
import com.g00fy2.punkapp.model.datasource.api.BeerDatasource
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import com.g00fy2.punkapp.model.datastore.BeerDatastoreImpl
import com.g00fy2.punkapp.model.transformer.BeerTransformer
import com.g00fy2.punkapp.model.transformer.BeerTransformerImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import timber.log.Timber

@Module(includes = [BackendStaticModule::class])
@InstallIn(SingletonComponent::class)
abstract class BackendModule {

  @Binds
  abstract fun provideBeerDatastore(beerDatastoreImpl: BeerDatastoreImpl): BeerDatastore

  @Binds
  abstract fun provideBeerTransformer(beerTransformerImpl: BeerTransformerImpl): BeerTransformer
}

@Module
@InstallIn(SingletonComponent::class)
object BackendStaticModule {

  @Provides
  fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor { Timber.tag("OkHttp").d(it) }.setLevel(if (BuildConfig.DEBUG) Level.BODY else Level.NONE)

  @Provides
  fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor).build()

  @Provides
  fun provideRetrofit(okHttpClient: Lazy<OkHttpClient>): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
      .callFactory { okHttpClient.get().newCall(it) }
      .build()
  }

  @Provides
  fun provideBeerDatasource(retrofit: Retrofit): BeerDatasource = retrofit.create(BeerDatasource::class.java)
}