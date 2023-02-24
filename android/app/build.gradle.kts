import org.jetbrains.kotlin.config.JvmTarget

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33
    namespace = "me.ilker.yet_another_kmp.app"

    defaultConfig {
        minSdk = 27
        targetSdk = 33

        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
    composeOptions {
        kotlinCompilerExtensionVersion = versionCatalog.findVersion("androidxComposeCompiler").get().toString()
    }

    kotlinOptions {
        jvmTarget = JvmTarget.JVM_11.description
    }
}

dependencies {
    implementation(project(mapOf("path" to ":shared:root")))
    implementation(project(mapOf("path" to ":shared:models")))
    implementation(project(mapOf("path" to ":android:navigation")))
    implementation(project(mapOf("path" to ":android:home")))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.core)
}
