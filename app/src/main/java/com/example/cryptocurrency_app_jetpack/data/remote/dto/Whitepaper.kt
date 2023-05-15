package com.example.cryptocurrency_app_jetpack.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Whitepaper(
        @SerializedName("link")
        val link: String,
        @SerializedName("thumbnail")
        val thumbnail: String
    )