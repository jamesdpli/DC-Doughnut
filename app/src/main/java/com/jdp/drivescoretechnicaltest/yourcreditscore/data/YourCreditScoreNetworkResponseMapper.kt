package com.jdp.drivescoretechnicaltest.yourcreditscore.data

import com.jdp.drivescoretechnicaltest.core.network.service.model.YourCreditScoreNetworkResponse
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.YourCreditScoreDomainModel
import javax.inject.Inject

class YourCreditScoreNetworkResponseMapper @Inject constructor() {

    fun map(networkResponse: YourCreditScoreNetworkResponse): YourCreditScoreDomainModel =
        YourCreditScoreDomainModel(
            creditScore = networkResponse.creditReportInfo.score
        )

}