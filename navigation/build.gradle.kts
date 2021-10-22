plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("io.gitlab.arturbosch.detekt")
}

android {
    compileSdk = ConfigProject.compileSdk

    defaultConfig {
        minSdk = ConfigProject.minSDK
        targetSdk = ConfigProject.targetSDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":module-injector"))

    //DI
    implementation(ProjectDependencies.Dagger.android)
    implementation(ProjectDependencies.Dagger.support)
    kapt(ProjectDependencies.Dagger.compiler)

    //Navigation
    implementation(ProjectDependencies.ModoNavigation.modo)

    //Coroutines
    implementation(ProjectDependencies.Coroutines.coroutinesCore)
    implementation(ProjectDependencies.Coroutines.coroutinesAndroid)

    //DebugTools
    implementation(ProjectDependencies.DebugTools.timber)

}