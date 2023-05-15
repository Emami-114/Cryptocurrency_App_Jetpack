package com.example.cryptocurrency_app_jetpack.data.repository

import com.example.cryptocurrency_app_jetpack.data.remote.CoinPaprikaApi
import com.example.cryptocurrency_app_jetpack.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency_app_jetpack.data.remote.dto.CoinDto
import com.example.cryptocurrency_app_jetpack.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}