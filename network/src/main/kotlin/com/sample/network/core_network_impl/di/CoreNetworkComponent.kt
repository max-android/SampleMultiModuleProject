package com.sample.network.core_network_impl.di

import com.sample.network.core_network_api.CoreNetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
abstract class CoreNetworkComponent : CoreNetworkApi {
    companion object {
        @Volatile
        private var coreNetworkComponent: CoreNetworkComponent? = null

        fun get(): CoreNetworkComponent {
            if (coreNetworkComponent == null) {
                synchronized(CoreNetworkComponent::class.java) {
                    if (coreNetworkComponent == null) {
                        coreNetworkComponent = DaggerCoreNetworkComponent.builder().build()
                    }
                }
            }
            return coreNetworkComponent!!
        }
    }
}