package com.sample.network.core_network_impl.di

import com.sample.network.core_network_api.CoreNetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class], dependencies = [CoreNetworkDependencies::class])
@Singleton
abstract class CoreNetworkComponent : CoreNetworkApi {

    companion object {
        fun initAndGet(dependencies: CoreNetworkDependencies): CoreNetworkComponent {
            return DaggerCoreNetworkComponent.builder()
                .coreNetworkDependencies(dependencies)
                .build()
        }
    }
}