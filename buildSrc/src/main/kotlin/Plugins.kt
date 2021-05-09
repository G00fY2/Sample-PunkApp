object Plugins {

  object Android {
    const val application = "com.android.application"
  }

  object Kotlin {
    const val androidGradle = "android"
    const val android = "kotlin-android"
    const val serializationGradle = "plugin.serialization"
    const val serialization = "kotlinx-serialization"
    const val kapt = "kotlin-kapt"
  }

  object Misc {
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detekt}"
    const val gradleVersions = "com.github.ben-manes.versions"
  }
}