include("app")

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
  }
}

pluginManagement {
  repositories {
    google()
    gradlePluginPortal()
  }
  resolutionStrategy {
    eachPlugin {
      when (requested.id.id) {
        "dagger.hilt.android.plugin" -> useModule("com.google.dagger:hilt-android-gradle-plugin:${requested.version}")
      }
    }
  }
}