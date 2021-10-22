// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ProjectDependencies.ProjectPlugin.gradle)
        classpath(ProjectDependencies.ProjectPlugin.kotlin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
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