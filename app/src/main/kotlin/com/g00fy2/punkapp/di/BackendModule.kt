package com.g00fy2.punkapp.di

import com.g00fy2.punkapp.BuildConfig
import com.g00fy2.punkapp.model.datasource.api.BeerDatasource
import com.g00fy2.punkapp.model.datastore.BeerDatastore
import com.g00fy2.punkapp.model.datastore.BeerDatastoreImpl
import com.g00fy2.punkapp.model.transformer.BeerTransformer
import com.g00fy2.punkapp.model.transformer.BeerTransformerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addNetworkInterceptor(
        HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }
          .setLevel(if (BuildConfig.DEBUG) Level.BODY else Level.NONE)
      )
      .build()
  }

  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
  }

  @Provides
  fun provideBeerDatasource(retrofit: Retrofit): BeerDatasource = retrofit.create(BeerDatasource::class.java)
}