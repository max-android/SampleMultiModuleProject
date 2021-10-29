package com.sample.network.core_network_impl.data.model

import com.google.gson.annotations.SerializedName

data class PhotoModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("download_url")
    val downloadUrl: String
): BaseModel