package com.sample.network.core_network_impl.data.rest

import com.sample.network.core_network_impl.data.model.ArticleModel
import retrofit2.Response
import retrofit2.http.GET

interface NewsRestService {
    @GET("ARTICLES")
    suspend fun articles(): Response<List<ArticleModel>>
}