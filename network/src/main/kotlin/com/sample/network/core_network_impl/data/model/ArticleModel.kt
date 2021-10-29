package com.sample.network.core_network_impl.data.model

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("url")
    val webUrl: String,
    @SerializedName("newsSite")
    val newsSite: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
): BaseModel