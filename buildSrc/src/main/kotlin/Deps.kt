object Deps {

  object AndroidX {
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.androidHiltNavigationCompose}"
  }

  object Kotlin {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    const val ktorClientOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    const val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorClientSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorClientLogging = "io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
  }

  object UI {
    const val accompanistInsets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
  }

  object Dagger {
    const val hilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
  }

  object Misc {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
  }
}