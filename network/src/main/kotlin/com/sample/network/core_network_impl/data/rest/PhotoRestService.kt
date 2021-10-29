package com.sample.network.core_network_impl.data.rest

import com.sample.network.core_network_impl.data.model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET

interface PhotoRestService {
    @GET("v2/list")
    suspend fun photos(): Response<List<PhotoModel>>
}