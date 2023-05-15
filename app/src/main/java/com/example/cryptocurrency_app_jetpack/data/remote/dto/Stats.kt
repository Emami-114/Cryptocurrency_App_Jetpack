package com.example.cryptocurrency_app_jetpack.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Stats(
            @SerializedName("subscribers")
            val subscribers: Int,
            @SerializedName("contributors")
            val contributors: Int,
            @SerializedName("stars")
            val stars: Int,
            @SerializedName("followers")
            val followers: Int
        )