package com.example.cryptocurrency_app_jetpack.domain.use_case.get_coins

import com.example.cryptocurrency_app_jetpack.common.Resource
import com.example.cryptocurrency_app_jetpack.data.remote.dto.toCoin
import com.example.cryptocurrency_app_jetpack.domain.model.Coin
import com.example.cryptocurrency_app_jetpack.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {

            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Es ist ein unerwarteter Fehler aufgetreten"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Der Server konnte nicht erreicht werden. Prüfe deine Internetverbindung"))
        }
    }
}