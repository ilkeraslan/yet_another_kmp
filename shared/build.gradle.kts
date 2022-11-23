plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android {
    compileSdk = 31

    namespace = "me.ilker.shared"
}

kotlin {
    android()

    iosArm64 { /* Apple iOS on ARM64 platforms (Apple iPhone 5s and newer) */ }
    iosX64 {
        /* Apple iOS simulator on x86_64 platforms */
        compilations {
            val oldSchoolCompilation by compilations.creating {
                defaultSourceSet {
                    languageSettings {
                        languageVersion = "1.5"
                    }
                }
            }

            tasks.register<Test>("oldSchoolCompilation") {
                println("Compiling for an old version")
            }
        }
    }

    sourceSets {
        val commonMain by sourceSets.getting
        val commonTest by sourceSets.getting
        val androidMain by sourceSets.getting
        val androidTest by sourceSets.getting
        val iosX64Main by sourceSets.getting
        val iosArm64Main by sourceSets.getting
        val iosMain by sourceSets.creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }
    }
}
