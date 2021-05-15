object Deps {

  object AndroidX {
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.androidHiltNavigationCompose}"
  }

  object Accompanist {
    const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
  }

  object Kotlin {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
  }

  object UI {
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
  }

  object OkHttp {
    const val bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttp}"
    const val okHttp = "com.squareup.okhttp3:okhttp"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor"
  }

  object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val serializationConverter =
      "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.serializationConverter}"
  }

  object Dagger {
    const val hilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
  }

  object Misc {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
  }
}