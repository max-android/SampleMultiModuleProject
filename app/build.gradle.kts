plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("io.gitlab.arturbosch.detekt")
    id("kotlin-parcelize")
}

android {
    compileSdk = ConfigProject.compileSdk

    defaultConfig {
        applicationId = ConfigProject.packageName
        minSdk = ConfigProject.minSDK
        targetSdk = ConfigProject.targetSDK
        versionCode = ConfigProject.versionCode
        versionName = ConfigProject.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ConfigProject.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":module-injector"))
    implementation(project(":network"))
    implementation(project(":navigation"))
    implementation(project(":feature-photo"))
    implementation(project(":feature-news"))
    implementation(project(":feature-memes"))
    implementation(project(":core"))

    //Base
    implementation(ProjectDependencies.Base.coreKtx)
    implementation(ProjectDependencies.Base.annotation)
    implementation(ProjectDependencies.Base.appCompat)
    implementation(ProjectDependencies.Base.material)

    //Compose
    implementation(ProjectDependencies.Compose.activityCompose)
    implementation(ProjectDependencies.Compose.constraintLayoutCompose)
    implementation(ProjectDependencies.Compose.composeCompiler)
    implementation(ProjectDependencies.Compose.ui)
    implementation(ProjectDependencies.Compose.accompanistUi)
    implementation(ProjectDependencies.Compose.accompanistInsets)
    implementation(ProjectDependencies.Compose.accompanistPager)
    implementation(ProjectDependencies.Compose.geometry)
    implementation(ProjectDependencies.Compose.graphics)
    implementation(ProjectDependencies.Compose.foundation)
    implementation(ProjectDependencies.Compose.runtimeCompose)
    implementation(ProjectDependencies.Compose.toolingPreview)
    implementation(ProjectDependencies.Compose.tooling)
    implementation(ProjectDependencies.Compose.runtimeSaved)

    //Coil
    implementation(ProjectDependencies.Image.coil)

    //DI
    implementation(ProjectDependencies.Dagger.android)
    implementation(ProjectDependencies.Dagger.support)
    kapt(ProjectDependencies.Dagger.compiler)

    //Navigation
    implementation(ProjectDependencies.ModoNavigation.modo)
    implementation(ProjectDependencies.ModoNavigation.modoRender)

    //Lifecycle
    implementation(ProjectDependencies.Lifecycle.lifecycleKtx)
    implementation(ProjectDependencies.Lifecycle.viewmodelKtx)
    implementation(ProjectDependencies.Lifecycle.lifecycleExt)
    implementation(ProjectDependencies.Lifecycle.viewModelCompose)
    implementation(ProjectDependencies.Lifecycle.livedata)
    implementation(ProjectDependencies.Lifecycle.runtimeLivedata)
    implementation(ProjectDependencies.Lifecycle.reactivestreams)

    //Collection
    implementation(ProjectDependencies.Collection.collection)

    //Coroutines
    implementation(ProjectDependencies.Coroutines.coroutinesCore)
    implementation(ProjectDependencies.Coroutines.coroutinesAndroid)

   //DebugTools
    implementation(ProjectDependencies.DebugTools.timber)

    //Test
    testImplementation(ProjectDependencies.Test.jUnit)
    androidTestImplementation(ProjectDependencies.Test.androidJUnit)
    androidTestImplementation(ProjectDependencies.Test.espresso)
}