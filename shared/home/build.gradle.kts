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
            }
        }

        val jvmMain by sourceSets.getting
    }
}
