object Deps {

  object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val activity = "androidx.activity:activity:${Versions.activity}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
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
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
  }

  object Misc {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
  }
}