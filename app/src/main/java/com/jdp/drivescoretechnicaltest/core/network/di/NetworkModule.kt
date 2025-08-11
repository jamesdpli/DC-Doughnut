package com.jdp.drivescoretechnicaltest.core.network.di

import com.jdp.drivescoretechnicaltest.core.network.service.YourCreditScoreService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(value = [SingletonComponent::class])
object NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit
        .Builder()
        .baseUrl("https://android-interview.s3.eu-west-2.amazonaws.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    fun provideOpenFoodsService(retrofit: Retrofit): YourCreditScoreService = retrofit
        .create(YourCreditScoreService::class.java)
}