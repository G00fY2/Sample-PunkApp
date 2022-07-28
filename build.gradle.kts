import com.android.build.gradle.BaseExtension
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.androidGradle) apply false
  alias(libs.plugins.kotlin.serializationGradle) apply false
  alias(libs.plugins.dagger.hilt) apply false
  alias(libs.plugins.misc.detekt) apply false
  alias(libs.plugins.misc.gradleVersions)
}

subprojects {
  apply(plugin = rootProject.libs.plugins.misc.detekt.get().pluginId)
  extensions.configure<DetektExtension> {
    toolVersion = rootProject.libs.versions.detekt.get()
    config = files("$rootDir/detekt.yml")
    buildUponDefaultConfig = true
    ignoredBuildTypes = listOf("release")
  }
  dependencies {
    add("detektPlugins", rootProject.libs.misc.detektFormatting)
  }
  tasks.withType<Detekt>().configureEach {
    jvmTarget = "11"
  }
  tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
      allWarningsAsErrors = true
      freeCompilerArgs = freeCompilerArgs + listOf(
        "-progressive",
        "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
        "-opt-in=coil.annotation.ExperimentalCoilApi"
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