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
}

kotlin {
    android()
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
}
