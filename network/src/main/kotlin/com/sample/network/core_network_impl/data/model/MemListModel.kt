package com.sample.network.core_network_impl.data.model

import com.google.gson.annotations.SerializedName

class MemListModel(
    @SerializedName("data")
    val memes: List<MemModel>
)