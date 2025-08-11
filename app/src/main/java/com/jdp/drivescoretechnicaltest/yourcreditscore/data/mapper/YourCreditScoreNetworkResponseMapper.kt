package com.jdp.drivescoretechnicaltest.yourcreditscore.data.mapper

import com.jdp.drivescoretechnicaltest.core.network.service.model.YourCreditScoreNetworkResponse
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel
import javax.inject.Inject

class YourCreditScoreNetworkResponseMapper @Inject constructor() {

    fun map(networkResponse: YourCreditScoreNetworkResponse): YourCreditScoreDomainModel = with(
        receiver = networkResponse
    ) {
        YourCreditScoreDomainModel(
            creditScore = creditReportInfo.score.toDouble(),
            maxCreditScore = creditReportInfo.maxScoreValue.toDouble()
        )
    }

}
