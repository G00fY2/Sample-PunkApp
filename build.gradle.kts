import com.android.build.gradle.BaseExtension
import com.android.build.gradle.BasePlugin
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.serialization) apply false
  alias(libs.plugins.kotlin.kapt) apply false
  alias(libs.plugins.dagger.hilt) apply false
  alias(libs.plugins.misc.detekt) apply false
  alias(libs.plugins.misc.gradleVersions)
}

subprojects {
  apply(plugin = rootProject.libs.plugins.misc.detekt.get().pluginId)
  extensions.configure<DetektExtension> {
    buildUponDefaultConfig = true
    disableDefaultRuleSets = true
    allRules = true
    config = files("$rootDir/detekt.yml")
    ignoredBuildTypes = listOf("release")
  }
  dependencies {
    add("detektPlugins", rootProject.libs.misc.detektFormatting)
    add("detektPlugins", rootProject.libs.misc.twitterComposeRules)
  }
  tasks.withType<Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_11.toString()
  }
  tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
      allWarningsAsErrors = true
      freeCompilerArgs = freeCompilerArgs + "-progressive"
      jvmTarget = JavaVersion.VERSION_11.toString()
    }
  }
  plugins.withType<BasePlugin>().configureEach {
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