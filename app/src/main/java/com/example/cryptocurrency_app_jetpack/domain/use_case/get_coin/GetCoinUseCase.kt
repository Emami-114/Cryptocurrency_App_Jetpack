package com.example.cryptocurrency_app_jetpack.domain.use_case.get_coin

import com.example.cryptocurrency_app_jetpack.common.Resource
import com.example.cryptocurrency_app_jetpack.data.remote.dto.toCoin
import com.example.cryptocurrency_app_jetpack.data.remote.dto.toCoinDetail
import com.example.cryptocurrency_app_jetpack.domain.model.Coin
import com.example.cryptocurrency_app_jetpack.domain.model.CoinDetail
import com.example.cryptocurrency_app_jetpack.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Es ist ein unerwarteter Fehler aufgetreten"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Der Server konnte nicht erreicht werden. Prüfe deine Internetverbindung"))
        }
    }
}