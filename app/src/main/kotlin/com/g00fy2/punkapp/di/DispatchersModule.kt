package com.g00fy2.punkapp.di

import com.g00fy2.punkapp.di.PunkDispatchers.IO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Suppress("InjectDispatcher")
@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

  @Provides
  @Dispatcher(IO)
  fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}