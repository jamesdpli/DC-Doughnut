package com.jdp.drivescoretechnicaltest.yourcreditscore.data.di

import com.jdp.drivescoretechnicaltest.core.network.service.YourCreditScoreService
import com.jdp.drivescoretechnicaltest.yourcreditscore.data.YourCreditScoreNetworkResponseMapper
import com.jdp.drivescoretechnicaltest.yourcreditscore.data.YourCreditScoreRepositoryImpl
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.YourCreditScoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(value = [SingletonComponent::class])
class YourCreditScoreRepositoryModule {

    @Provides
    @Singleton
    fun provideOpenFoodsRepository(
        mapper: YourCreditScoreNetworkResponseMapper,
        service: YourCreditScoreService
    ): YourCreditScoreRepository = YourCreditScoreRepositoryImpl(
        service = service,
        mapper = mapper
    )

}