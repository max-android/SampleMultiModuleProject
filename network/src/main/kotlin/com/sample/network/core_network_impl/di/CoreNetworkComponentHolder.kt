package com.sample.network.core_network_impl.di

import com.sample.injector.ComponentHolder
import com.sample.network.core_network_api.CoreNetworkApi

object CoreNetworkComponentHolder : ComponentHolder<CoreNetworkApi, CoreNetworkDependencies> {

    @Volatile
    private var coreNetworkComponent: CoreNetworkComponent? = null

    override fun init(dependencies: CoreNetworkDependencies) {
        if (coreNetworkComponent == null) {
            synchronized(CoreNetworkComponentHolder::class.java) {
                if (coreNetworkComponent == null) {
                    coreNetworkComponent = CoreNetworkComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): CoreNetworkApi {
        return getComponent()
    }

    override fun reset() {
        coreNetworkComponent = null
    }

    internal fun getComponent(): CoreNetworkComponent {
        checkNotNull(coreNetworkComponent) { "CoreNetworkComponent was not initialized!" }
        return coreNetworkComponent!!
    }

}