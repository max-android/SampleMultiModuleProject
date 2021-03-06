plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("io.gitlab.arturbosch.detekt")
}

android {
    compileSdk = ConfigProject.compileSdk

    defaultConfig {
        minSdk = ConfigProject.minSDK
        targetSdk = ConfigProject.targetSDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField ("String", "NEWS_BASE_URL", "\"https://api.spaceflightnewsapi.net/v3/\"")
        buildConfigField ("String" ,"MEMES_BASE_URL", "\"https://api.doge-meme.lol/v1/\"")
        buildConfigField ("String", "PHOTO_BASE_URL", "\"https://picsum.photos/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    //Coroutines
    implementation(ProjectDependencies.Coroutines.coroutinesCore)
    implementation(ProjectDependencies.Coroutines.coroutinesAndroid)

    //Networking
    implementation(ProjectDependencies.Networking.retrofit)
    implementation(ProjectDependencies.Networking.retrofitConverter)
    implementation(ProjectDependencies.Networking.loggingInterceptor)
    implementation(ProjectDependencies.Gson.gson)

    //DebugTools
    implementation(ProjectDependencies.DebugTools.timber)
}