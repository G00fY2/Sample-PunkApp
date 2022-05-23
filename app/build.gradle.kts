plugins {
  id(Plugins.Android.application)
  id(Plugins.Kotlin.android)
  id(Plugins.Kotlin.serialization)
  id(Plugins.Kotlin.kapt)
  id(Plugins.Misc.daggerHilt)
}

android {
  namespace = "com.g00fy2.punkapp"
  compileSdk = Versions.androidCompileSdk
  buildToolsVersion = Versions.androidBuildTools
  defaultConfig {
    applicationId = "com.g00fy2.punkapp"
    minSdk = Versions.androidMinSdk
    targetSdk = Versions.androidTargetSdk
    versionCode = 1
    versionName = "1.0"

    buildConfigField("String", "BASE_URL", "\"https://api.punkapi.com/v2/\"")
  }
  buildTypes {
    getByName("release") {
      isShrinkResources = true
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  buildFeatures {
    compose = true
    aidl = false
    renderScript = false
    resValues = false
    shaders = false
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.composeCompiler
  }
}

dependencies {
  // Kotlin
  implementation(Deps.Kotlin.coroutines)
  implementation(Deps.Kotlin.serialization)

  // AndroidX
  implementation(Deps.AndroidX.activityCompose)
  implementation(Deps.AndroidX.composeMaterial)
  debugImplementation(Deps.AndroidX.composeUITooling)
  implementation(Deps.AndroidX.composeUIToolingPreview)
  implementation(Deps.AndroidX.composeNavigation)

  // UI
  implementation(Deps.UI.materialDesign)
  implementation(Deps.UI.coil)

  // Misc
  implementation(Deps.Misc.timber)

  // Web
  implementation(Deps.Kotlin.ktorClientOkHttp)
  implementation(Deps.Kotlin.ktorClientContentNegotiation)
  implementation(Deps.Kotlin.ktorClientSerialization)
  implementation(Deps.Kotlin.ktorClientLogging)

  // Hilt
  implementation(Deps.Dagger.hilt)
  implementation(Deps.AndroidX.hiltNavigationCompose)
  kapt(Deps.Dagger.hiltCompiler)
}

kapt {
  correctErrorTypes = true
}