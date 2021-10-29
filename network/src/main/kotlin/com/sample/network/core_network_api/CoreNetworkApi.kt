package com.sample.network.core_network_api

import com.sample.injector.BaseAPI
import com.sample.network.core_network_impl.data.rest.MemesRestService
import com.sample.network.core_network_impl.data.rest.NewsRestService
import com.sample.network.core_network_impl.data.rest.PhotoRestService

interface CoreNetworkApi: BaseAPI {
    fun memesRestService(): MemesRestService
    fun newsRestService(): NewsRestService
    fun photoRestService(): PhotoRestService
}