include("app")

pluginManagement {
  repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
  }
  resolutionStrategy {
    eachPlugin {
      when (requested.id.id) {
        "com.android.application" -> useModule("com.android.tools.build:gradle:${requested.version}")
        "dagger.hilt.android.plugin" -> useModule("com.google.dagger:hilt-android-gradle-plugin:${requested.version}")
      }
    }
  }
}