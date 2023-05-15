package com.example.cryptocurrency_app_jetpack.domain.repository

import com.example.cryptocurrency_app_jetpack.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency_app_jetpack.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}