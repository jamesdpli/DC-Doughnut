package com.jdp.drivescoretechnicaltest.yourcreditscore.domain

import com.jdp.drivescoretechnicaltest.core.network.Resource

interface YourCreditScoreRepository {
    suspend fun getYourCreditScore(): Resource<YourCreditScoreDomainModel>
}