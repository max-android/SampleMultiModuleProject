package com.sample.navigation.core_nav_impl.di

import com.sample.navigation.core_nav_impl.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigatorModule {

    @Singleton
    @Provides
    fun provideNavigator() = Navigator()

}