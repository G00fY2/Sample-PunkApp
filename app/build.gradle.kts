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
    viewBinding = true
    aidl = false
    renderScript = false
    resValues = false
    shaders = false
  }
  sourceSets.getByName("main").java.srcDirs("src/main/kotlin")
}

dependencies {
  // Kotlin
  implementation(Deps.Kotlin.coroutines)
  implementation(Deps.Kotlin.serialization)

  // AndroidX
  implementation(Deps.AndroidX.appcompat)
  implementation(Deps.AndroidX.core)
  implementation(Deps.AndroidX.activity)
  implementation(Deps.AndroidX.fragment)
  implementation(Deps.AndroidX.lifecycle)
  implementation(Deps.AndroidX.recyclerView)
  implementation(Deps.AndroidX.constraintLayout)

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

  // Dagger
  implementation(Deps.Dagger.daggerHilt)
  kapt(Deps.Dagger.daggerHiltCompiler)
}

kapt {
  correctErrorTypes = true
}