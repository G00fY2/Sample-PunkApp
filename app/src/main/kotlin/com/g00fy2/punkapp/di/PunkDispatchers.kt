package com.g00fy2.punkapp.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val punkDispatcher: PunkDispatchers)

enum class PunkDispatchers {
  IO
}