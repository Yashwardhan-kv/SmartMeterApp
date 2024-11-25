pluginManagement {
    repositories {
        google() // Google's Maven repository
        mavenCentral() // Central Maven repository for dependencies
        gradlePluginPortal() // Gradle Plugin Portal for plugin dependencies
        maven("https://jitpack.io") // JitPack repository for MPAndroidChart and other third-party libraries
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // Fail on project repository conflicts
    repositories {
        google() // Google's Maven repository
        mavenCentral() // Central Maven repository for dependencies
        maven("https://jitpack.io") // Ensure JitPack is included for MPAndroidChart
    }
}

rootProject.name = "SmartMeterApp"
include(":app")
