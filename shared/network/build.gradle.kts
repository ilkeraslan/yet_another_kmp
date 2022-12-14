plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

android {
    compileSdk = 31
    namespace = "me.ilker.shared.network"

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

        getByName("debug") {
            isMinifyEnabled = false
            isJniDebuggable = true
        }
    }
}

kotlin {
    android()

    iosArm64 {
        /* Apple iOS on ARM64 platforms (Apple iPhone 5s and newer) */
        this.binaries.framework {
            baseName = "YetAnotherKMPNetwork"
        }
    }

    iosX64 {
        /* Apple iOS simulator on x86_64 platforms */
        this.binaries.framework {
            baseName = "YetAnotherKMPNetwork"
        }
    }

    iosSimulatorArm64 {
        /* Apple iOS simulator on Apple Silicon platforms */
        this.binaries.framework {
            baseName = "YetAnotherKMPNetwork"
        }
    }

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

        val androidMain by sourceSets.getting {
            dependencies {
                implementation(libs.ktor.client.android)
            }
        }

        val jvmMain by sourceSets.getting

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        val iosMain by sourceSets.creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}
