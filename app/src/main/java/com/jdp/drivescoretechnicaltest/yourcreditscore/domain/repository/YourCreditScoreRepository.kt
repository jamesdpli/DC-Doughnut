package com.jdp.drivescoretechnicaltest.yourcreditscore.domain.repository

import com.jdp.drivescoretechnicaltest.core.network.Resource
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel

interface YourCreditScoreRepository {
    suspend fun getYourCreditScore(): Resource<YourCreditScoreDomainModel>
}