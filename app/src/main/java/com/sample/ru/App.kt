package com.sample.ru

import android.app.Application
import android.content.Context
import com.sample.ru.di.AppComponent
import com.sample.ru.di.DaggerAppComponent
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        appContext = applicationContext
        initDI()
        initRoute()
    }

    private fun initDI() {
        AppComponent.init(iniAppComponent())
        AppComponent.get().inject(this)
    }

    private fun iniAppComponent() = DaggerAppComponent.builder()
        .build()

    private fun initRoute() {
        AppComponent.get().getNavigatorApi().navigator().initRouter(this)
    }

    private fun initTimber() {
        // if (BuildConfig.DEBUG) {
        Timber.plant(Timber.DebugTree())
        // }
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }

}