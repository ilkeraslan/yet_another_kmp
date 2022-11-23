plugins {
    kotlin("multiplatform")
    id("com.android.application")
    alias(libs.plugins.hilt.plugin)
    kotlin("kapt")
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

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/LICENSE")
            add("META-INF/*.properties")
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
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

dependencies {
    implementation(libs.android.hilt)
    implementation(libs.android.hilt.compiler)
}

kapt {
    correctErrorTypes = true
}
