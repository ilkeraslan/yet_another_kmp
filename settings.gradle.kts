rootProject.name = "yet_another_kmp"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

include("shared")
include(":android")
include(":ios")
include(":server")