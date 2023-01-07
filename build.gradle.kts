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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("com.android.tools.build:gradle:7.2.2")

        // https://issuetracker.google.com/issues/240445963
        classpath("org.apache.commons:commons-compress:1.21")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
