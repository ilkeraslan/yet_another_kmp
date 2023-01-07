group = "me.ilker"
version = "1.0-SNAPSHOT"

buildscript {
    val kotlinVersion: String by project

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        // https://issuetracker.google.com/issues/240445963
        classpath("org.apache.commons:commons-compress:1.21")
    }
}

plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.application) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.library) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.serialization) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.android) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.sqlDelight) apply false
}