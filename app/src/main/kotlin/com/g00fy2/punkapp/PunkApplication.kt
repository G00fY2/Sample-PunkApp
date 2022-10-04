package com.g00fy2.punkapp

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.util.DebugLogger
import dagger.Lazy
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class PunkApplication : Application(), ImageLoaderFactory {

  @Inject
  lateinit var okHttpClient: Lazy<OkHttpClient>

  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
  }

  override fun newImageLoader(): ImageLoader {
    return ImageLoader.Builder(this)
      .memoryCache {
        MemoryCache.Builder(this)
          .maxSizePercent(0.2) // 20% of the app's available memory
          .build()
      }
      .diskCache {
        DiskCache.Builder()
          .directory(cacheDir.resolve("image_cache"))
          .maxSizePercent(0.02) // 2% of the device's free disk space
          .minimumMaxSizeBytes(10L * 1024 * 1024) // 10MB min
          .maximumMaxSizeBytes(250L * 1024 * 1024) // 250MB max
          .build()
      }
      .okHttpClient { okHttpClient.get() }
      .respectCacheHeaders(false) // always read from/write to the disk cache
      .apply { if (BuildConfig.DEBUG) logger(DebugLogger()) }
      .build()
  }
}