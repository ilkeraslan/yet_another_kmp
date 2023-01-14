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
                implementation(project(mapOf("path" to ":shared:models")))
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx)
            }
        }

        val jvmMain by sourceSets.getting
    }
}
