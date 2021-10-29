package com.sample.network.core_network_impl.data.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("name")
    val errorName: String = "",
    @SerializedName("message")
    val errorMessage: String = ""
)