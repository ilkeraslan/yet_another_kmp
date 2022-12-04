plugins {
    kotlin("multiplatform")
    id("com.android.application")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 24
        targetSdk = 31

        versionCode = 1
        versionName = "1.0"
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

    namespace = "me.ilker.yet_another_kmp"
}

kotlin {
    android()
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
}

dependencies {
    implementation(libs.koin.android)
    implementation(libs.koin.core)
}
