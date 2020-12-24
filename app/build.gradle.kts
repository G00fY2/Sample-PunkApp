plugins {
  id(Plugins.Android.application)
  id(Plugins.Kotlin.android)
  id(Plugins.Kotlin.kapt)
  id(Plugins.Misc.daggerHilt)
}

android {
  compileSdkVersion(Config.androidCompileSdkVersion)
  buildToolsVersion = Config.buildToolsVersion
  defaultConfig {
    applicationId = Config.applicationId
    minSdkVersion(Config.androidMinSdkVersion)
    targetSdkVersion(Config.androidTargetSdkVersion)
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
    viewBinding = true
    aidl = false
    renderScript = false
    resValues = false
    shaders = false
  }
  sourceSets.getByName("main").java.srcDirs("src/main/kotlin")
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    allWarningsAsErrors = true
    jvmTarget = JavaVersion.VERSION_1_8.toString()
    freeCompilerArgs = listOf("-progressive")
    useIR = true
  }
}

repositories {
  google()
  mavenCentral()
  maven("https://dl.bintray.com/kotlin/kotlin-eap")
  maven("https://kotlin.bintray.com/kotlinx")
}

dependencies {
  // Kotlin
  implementation(Deps.Kotlin.coroutines)

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
  implementation(Deps.Retrofit.moshiConverter)

  implementation(Deps.Moshi.moshi)
  kapt(Deps.Moshi.moshiCompiler)

  // Dagger
  implementation(Deps.Dagger.daggerHilt)
  kapt(Deps.Dagger.daggerHiltCompiler)
}

kapt {
  correctErrorTypes = true
}