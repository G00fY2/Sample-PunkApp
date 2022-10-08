@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.kotlin.kapt)
  alias(libs.plugins.dagger.hilt)
}

android {
  namespace = "com.g00fy2.punkapp"
  compileSdk = rootProject.libs.versions.androidconfig.compileSdk.get().toInt()
  buildToolsVersion = rootProject.libs.versions.androidconfig.buildTools.get()
  defaultConfig {
    applicationId = "com.g00fy2.punkapp"
    minSdk = rootProject.libs.versions.androidconfig.minSdk.get().toInt()
    targetSdk = rootProject.libs.versions.androidconfig.targetSdk.get().toInt()
    versionCode = 1
    versionName = "1.0"

    resourceConfigurations.add("en")

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
    kotlinCompilerExtensionVersion = rootProject.libs.versions.composeCompiler.get()
  }
}

dependencies {
  // Kotlin
  implementation(libs.kotlin.coroutines)
  implementation(libs.kotlin.serialization)

  // AndroidX
  implementation(libs.androidx.activityCompose)
  implementation(libs.androidx.composeMaterial)
  debugImplementation(libs.androidx.composeUiTooling)
  implementation(libs.androidx.composeUiToolingPreview)
  implementation(libs.androidx.composeFoundation)
  implementation(libs.androidx.composeNavigation)
  implementation(libs.androidx.lifecycleRuntimeCompose)

  // UI
  implementation(libs.ui.materialDesign)
  implementation(libs.ui.coil)

  // Misc
  implementation(libs.misc.timber)

  // Ktor
  implementation(libs.kotlin.ktorClientOkHttp)
  implementation(libs.kotlin.ktorClientContentNegotiation)
  implementation(libs.kotlin.ktorClientSerialization)
  implementation(libs.kotlin.ktorClientLogging)

  // Hilt
  implementation(libs.dagger.hilt)
  implementation(libs.androidx.hiltNavigationCompose)
  kapt(libs.dagger.hiltCompiler)
}

kapt {
  correctErrorTypes = true
}