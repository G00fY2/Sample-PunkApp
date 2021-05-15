plugins {
  id(Plugins.Android.application)
  id(Plugins.Kotlin.android)
  id(Plugins.Kotlin.serialization)
  id(Plugins.Kotlin.kapt)
  id(Plugins.Misc.daggerHilt)
}

android {
  compileSdkVersion(Versions.androidCompileSdk)
  buildToolsVersion = Versions.androidBuildTools
  defaultConfig {
    applicationId = "com.g00fy2.punkapp"
    minSdkVersion(Versions.androidMinSdk)
    targetSdkVersion(Versions.androidTargetSdk)
    versionCode = 1
    versionName = "1.0"

    buildConfigField("String", "BASE_URL", "\"https://api.punkapi.com/v2/\"")
  }
  buildTypes {
    getByName("release") {
      //isShrinkResources = true
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
    kotlinCompilerExtensionVersion = Versions.compose
  }
  sourceSets.getByName("main").java.srcDirs("src/main/kotlin")
}

dependencies {
  // Kotlin
  implementation(Deps.Kotlin.coroutines)
  implementation(Deps.Kotlin.serialization)

  // AndroidX
  implementation(Deps.AndroidX.activityCompose)
  implementation(Deps.AndroidX.composeUI)
  implementation(Deps.AndroidX.composeMaterial)
  implementation(Deps.AndroidX.composeUITooling)
  implementation(Deps.AndroidX.composeLiveData)
  implementation(Deps.AndroidX.composeNavigation)
  implementation(Deps.AndroidX.liveData)

  // Accompanist
  implementation(Deps.Accompanist.insets)

  // UI
  implementation(Deps.UI.materialDesign)
  implementation(Deps.UI.coil)

  // Misc
  implementation(Deps.Misc.timber)

  // Web
  implementation(platform(Deps.OkHttp.bom))
  implementation(Deps.OkHttp.okHttp)
  implementation(Deps.OkHttp.interceptor)

  implementation(Deps.Retrofit.retrofit)
  implementation(Deps.Retrofit.serializationConverter)

  // Hilt
  implementation(Deps.Dagger.hilt)
  implementation(Deps.AndroidX.hiltNavigationCompose)
  kapt(Deps.Dagger.hiltCompiler)
}

kapt {
  correctErrorTypes = true
}