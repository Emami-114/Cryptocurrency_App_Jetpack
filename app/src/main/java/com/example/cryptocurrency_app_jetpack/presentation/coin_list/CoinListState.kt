package com.example.cryptocurrency_app_jetpack.presentation.coin_list

import com.example.cryptocurrency_app_jetpack.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
