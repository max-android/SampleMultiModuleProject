package com.sample.navigation.core_nav_impl.di

import com.sample.navigation.core_nav_api.NavigatorApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NavigatorModule::class])
@Singleton
abstract class NavigatorComponent: NavigatorApi {

    companion object {
        @Volatile
        private var navigatorComponent: NavigatorComponent? = null

        fun get(): NavigatorComponent {
            if (navigatorComponent == null) {
                synchronized(NavigatorComponent::class.java) {
                    if (navigatorComponent == null) {
                        navigatorComponent = DaggerNavigatorComponent.builder().build()
                    }
                }
            }
            return navigatorComponent!!
        }
    }

}