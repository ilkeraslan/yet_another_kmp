plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
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
                implementation(libs.kotlinx.serialization.json)
            }
        }

        val jvmMain by sourceSets.getting
    }
}
