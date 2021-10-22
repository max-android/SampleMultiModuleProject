// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ProjectDependencies.ProjectPlugin.gradle)
        classpath(ProjectDependencies.ProjectPlugin.kotlin)
    }
}

plugins {
    id(ProjectDependencies.ProjectPlugin.detekt)
        .version(ProjectDependencies.ProjectPlugin.detektVersion).apply(false)
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}