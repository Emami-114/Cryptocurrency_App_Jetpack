package com.example.cryptocurrency_app_jetpack.data.remote.dto


import com.example.cryptocurrency_app_jetpack.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("team")
    val team: List<TeamMember>,
    @SerializedName("description")
    val description: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("last_data_at")
    val lastDataAt: String
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}