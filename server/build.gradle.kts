import org.jetbrains.kotlin.config.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.ktor.plugin.features.DockerImageRegistry
import io.ktor.plugin.features.JreVersion

plugins {
    application
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.8.0"
    @Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
    id(libs.plugins.ktor.get().pluginId) version "2.2.2"
}

application {
    mainClass.set("ServerKt")
}

ktor {
    fatJar {
        archiveFileName.set("server.jar")
    }

    docker {
        jreVersion.set(JreVersion.JRE_17)
        localImageName.set("server-docker-image")
        imageTag.set("0.0.1-preview")

        externalRegistry.set(
            DockerImageRegistry.dockerHub(
                appName = provider { "yet-another-kmp" },
                username = providers.environmentVariable("DOCKER_HUB_USERNAME"),
                password = providers.environmentVariable("DOCKER_HUB_PASSWORD")
            )
        )
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":shared:models"))

    implementation(libs.ktor.cors)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx)
    implementation(libs.logback)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JvmTarget.JVM_11.description
}