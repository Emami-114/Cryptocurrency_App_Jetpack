package com.example.cryptocurrency_app_jetpack.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LinksExtended(
        @SerializedName("url")
        val url: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("stats")
        val stats: Stats
    )