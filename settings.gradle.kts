rootProject.name = "yet_another_kmp"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

include(":shared")
include(":shared:models")
include(":android")
include(":ios")
include(":server")