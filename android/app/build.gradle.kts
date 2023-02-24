import org.jetbrains.kotlin.config.JvmTarget

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    namespace = "me.ilker.yet_another_kmp.app"

    defaultConfig {
        minSdk = 24
        targetSdk = 31

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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    kotlinOptions {
        jvmTarget = JvmTarget.JVM_11.description
    }
}

dependencies {
    implementation(project(mapOf("path" to ":shared:root")))
    implementation(project(mapOf("path" to ":shared:models")))

    implementation(libs.androidx.activity.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.core)
}
