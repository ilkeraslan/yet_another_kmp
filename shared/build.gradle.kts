plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.0"
}

android {
    compileSdk = 31
    namespace = "me.ilker.shared"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

kotlin {
    android {
        publishAllLibraryVariants()
    }

    iosArm64 {
        /* Apple iOS on ARM64 platforms (Apple iPhone 5s and newer) */
        this.binaries.framework {
            baseName = "YetAnotherKMP"
        }
    }

    iosX64 {
        /* Apple iOS simulator on x86_64 platforms */
        this.binaries.framework {
            baseName = "YetAnotherKMP"
        }
    }

    iosSimulatorArm64 {
        /* Apple iOS simulator on Apple Silicon platforms */
        this.binaries.framework {
            baseName = "YetAnotherKMP"
        }
    }

    jvm()

    sourceSets {
        val commonMain by sourceSets.getting {
            dependencies {
//                implementation(libs.kotlinx.serialization)
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
            }
        }

        val commonTest by sourceSets.getting
        val androidMain by sourceSets.getting
        val androidTest by sourceSets.getting
        val jvmMain by sourceSets.getting
        val jvmTest by sourceSets.getting

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        val iosMain by sourceSets.creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}
