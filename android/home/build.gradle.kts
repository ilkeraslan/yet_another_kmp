import org.jetbrains.kotlin.config.JvmTarget

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 31
    namespace = "me.ilker.yet_another_kmp.home"

    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        jvmTarget = JvmTarget.JVM_11.description
    }
}

dependencies {
    implementation(project(":android:navigation"))
    implementation(libs.androidx.navigation.compose)
}
