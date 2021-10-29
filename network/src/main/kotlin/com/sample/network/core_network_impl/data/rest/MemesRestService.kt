package com.sample.network.core_network_impl.data.rest

import com.sample.network.core_network_impl.data.model.MemListModel
import retrofit2.Response
import retrofit2.http.GET

interface MemesRestService {
    @GET("memes/")
    suspend fun memes(): Response<MemListModel>
}