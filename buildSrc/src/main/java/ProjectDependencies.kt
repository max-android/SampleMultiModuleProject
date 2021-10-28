
object ProjectDependencies {

    object ProjectPlugin {
        const val gradle = "com.android.tools.build:gradle:7.0.3"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31"
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val detektVersion = "1.18.1"
    }

    object Base {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val annotation = "androidx.annotation:annotation:1.2.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.6"
    }

    object Compose {
        private const val version = "1.0.4"
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val composeCompiler = "androidx.compose.compiler:compiler:$version"
        const val accompanistUi = "com.google.accompanist:accompanist-systemuicontroller:0.19.0"
        const val accompanistInsets = "dev.chrisbanes.accompanist:accompanist-insets:0.6.2"
        const val accompanistPager = "com.google.accompanist:accompanist-pager:0.19.0"
        const val geometry = "androidx.compose.ui:ui-geometry:$version"
        const val graphics = "androidx.compose.ui:ui-graphics:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val runtimeCompose = "androidx.compose.runtime:runtime:$version"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val runtimeSaved =
            "androidx.compose.runtime:runtime-saved-instance-state:1.0.0-alpha11"
        const val constraintLayoutCompose =
            "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc01"
    }

    object Image {
        const val coil = "io.coil-kt:coil-compose:1.3.2"
    }

    object Dagger {
        private const val version = "2.39.1"
        const val android = "com.google.dagger:dagger-android:$version"
        const val support = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val kotlinxMetadata = "org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.2.0"
    }

    object Room {
        private const val version = "2.3.0"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:2.4.0-alpha04"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object ModoNavigation {
        const val modo = "com.github.terrakok:modo:0.6.1"
        const val modoRender = "com.github.terrakok:modo-render-android-fm:0.6.1"
    }

    object Lifecycle {
        private const val version = "2.3.1"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-rc01"
        const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-rc01"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:1.0.4"
        const val reactivestreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:$version"
    }

    object Collection {
        const val collection = "androidx.collection:collection-ktx:1.2.0-alpha01"
    }

    object Coroutines {
        private const val version = "1.5.2"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Gson {
        const val gson = "com.google.code.gson:gson:2.8.8"
    }

    object Networking {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.1"
    }

    object Datastore {
        const val datastorePreferences = "androidx.datastore:datastore-preferences:1.0.0"
    }

    object DebugTools {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val androidJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:2.0.9"
    }
}