package com.example.cryptocurrency_app_jetpack.di

import com.example.cryptocurrency_app_jetpack.common.Constants.BASE_URL
import com.example.cryptocurrency_app_jetpack.data.remote.CoinPaprikaApi
import com.example.cryptocurrency_app_jetpack.data.repository.CoinRepositoryImpl
import com.example.cryptocurrency_app_jetpack.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}