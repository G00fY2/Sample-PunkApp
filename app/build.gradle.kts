plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.g00fy2.punkapp"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "BASE_URL", "\"https://api.punkapi.com/v2/\"")
    }
    buildTypes {
        getByName("release") {
            isShrinkResources = false
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }
    buildFeatures {
        viewBinding = true
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.0-M1")

    // AndroidX
    implementation("androidx.appcompat:appcompat:1.3.0-alpha02")
    implementation("androidx.core:core-ktx:1.5.0-alpha04")
    implementation("androidx.activity:activity:1.2.0-beta01")
    implementation("androidx.fragment:fragment:1.3.0-beta01")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-beta01")
    implementation("androidx.recyclerview:recyclerview:1.2.0-alpha06")
    implementation("androidx.constraintlayout:constraintlayout:2.0.2")

    // UI
    implementation("com.google.android.material:material:1.3.0-alpha03")
    implementation("io.coil-kt:coil:1.0.0-rc3")

    // Misc
    implementation("com.jakewharton.timber:timber:4.7.1")

    // Web
    implementation("com.squareup.moshi:moshi:1.11.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0-RC1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0-RC1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Dagger
    implementation("com.google.dagger:hilt-android:${properties["daggerVersion"]}")
    kapt("com.google.dagger:hilt-android-compiler:${properties["daggerVersion"]}")
}

kapt {
    correctErrorTypes = true
}