package com.jdp.drivescoretechnicaltest.yourcreditscore.data.di

import com.jdp.drivescoretechnicaltest.core.network.service.YourCreditScoreService
import com.jdp.drivescoretechnicaltest.yourcreditscore.data.mapper.YourCreditScoreNetworkResponseMapper
import com.jdp.drivescoretechnicaltest.yourcreditscore.data.repository.YourCreditScoreRepositoryImpl
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.repository.YourCreditScoreRepository
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