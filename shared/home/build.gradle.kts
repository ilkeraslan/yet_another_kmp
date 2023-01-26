plugins {
    kotlin("multiplatform")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by sourceSets.getting {
            dependencies {
                implementation(project(":shared:models"))
                implementation(project(":shared:utils"))
                implementation(libs.decompose)
                implementation(libs.mvi.kotlin)
                implementation(libs.mvi.kotlin.extensions.coroutines)
            }
        }

        val jvmMain by sourceSets.getting
    }
}
