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
                implementation(libs.decompose)
                implementation(libs.mvi.kotlin)
            }
        }

        val commonTest by sourceSets.getting
        val jvmMain by sourceSets.getting
        val jvmTest by sourceSets.getting
    }
}
