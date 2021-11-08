package com.sample.network.core_network_impl.di

import android.content.Context
import com.sample.injector.BaseDependencies

interface CoreNetworkDependencies: BaseDependencies {
    fun context(): Context
}