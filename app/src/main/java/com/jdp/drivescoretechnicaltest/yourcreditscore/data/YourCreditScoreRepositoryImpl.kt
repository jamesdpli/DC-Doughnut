package com.jdp.drivescoretechnicaltest.yourcreditscore.data

import com.jdp.drivescoretechnicaltest.core.network.Resource
import com.jdp.drivescoretechnicaltest.core.network.safeApiCall
import com.jdp.drivescoretechnicaltest.core.network.service.YourCreditScoreService
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.YourCreditScoreDomainModel
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.YourCreditScoreRepository
import javax.inject.Inject

class YourCreditScoreRepositoryImpl @Inject constructor(
    private val service: YourCreditScoreService,
    private val mapper: YourCreditScoreNetworkResponseMapper
) : YourCreditScoreRepository {

    override suspend fun getYourCreditScore(): Resource<YourCreditScoreDomainModel> = safeApiCall {
        mapper.map(networkResponse = service.getYourCreditScore())
    }

}
