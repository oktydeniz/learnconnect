// Top-level build file where you can add configuration options common to all sub-projects/modules.



buildscript {
    repositories {
        google()  // Make sure this is included
        mavenCentral()
    }
    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")  // Safe Args plugin
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}