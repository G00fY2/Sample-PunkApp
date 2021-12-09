import com.android.build.gradle.BaseExtension
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id(Plugins.Android.application) version Versions.androidGradle apply false
  kotlin(Plugins.Kotlin.androidGradle) version Versions.kotlin apply false
  kotlin(Plugins.Kotlin.serializationGradle) version Versions.kotlin apply false
  id(Plugins.Misc.daggerHilt) version Versions.daggerHilt apply false
  id(Plugins.Misc.detekt) version Versions.detekt apply false
  id(Plugins.Misc.gradleVersions) version Versions.gradleVersions
}

subprojects {
  apply(plugin = Plugins.Misc.detekt)
  extensions.configure<DetektExtension> {
    toolVersion = Versions.detekt
    config = files("$rootDir/detekt.yml")
    buildUponDefaultConfig = true
    ignoredBuildTypes = listOf("release")
  }
  dependencies {
    "detektPlugins"(Plugins.Misc.detektFormatting)
  }
  tasks.withType<Detekt>().configureEach {
    jvmTarget = "11"
  }
  tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
      allWarningsAsErrors = true
      freeCompilerArgs = freeCompilerArgs + listOf(
        "-progressive",
        "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi",
        "-Xopt-in=coil.annotation.ExperimentalCoilApi"
      )
      jvmTarget = "11"
    }
  }
  afterEvaluate {
    extensions.configure<BaseExtension> {
      compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
      }
    }
  }
}

tasks.register<Delete>("clean") {
  delete(buildDir)
}