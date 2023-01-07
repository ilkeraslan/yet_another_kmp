plugins {
    kotlin("multiplatform")
    id("com.android.application")
}

android {
    compileSdk = 31
    namespace = "me.ilker.yet_another_kmp"

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
        }
    }
}

kotlin {
    android()
}

dependencies {
    implementation(project(":shared:models"))

    implementation(libs.koin.android)
    implementation(libs.koin.core)
}
