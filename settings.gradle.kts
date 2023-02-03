rootProject.name = "yet_another_kmp"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.google.cloud.tools.appengine")) {
                useModule("com.google.cloud.tools:appengine-gradle-plugin:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":shared:root")
include(":shared:models")
include(":shared:network")
include(":shared:home")
include(":android:app")
include(":android:navigation")
include(":ios")
include(":server")