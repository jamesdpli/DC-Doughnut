package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.mapper

import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.model.YourCreditScoreUIModel
import javax.inject.Inject

class YourCreditScoreDomainModelMapper @Inject constructor() {

    fun map(domainModel: YourCreditScoreDomainModel): YourCreditScoreUIModel = with(
        receiver = domainModel
    ) {
        return YourCreditScoreUIModel(
            creditScore = creditScore.toString(),
            maxCreditScore = maxCreditScore.toString(),
            doughnutSweepAngle = calculateDoughnutSweepAngle(domainModel = domainModel)
        )
    }

    private fun calculateDoughnutSweepAngle(domainModel: YourCreditScoreDomainModel): Float = with(
        receiver = domainModel
    ) {
        (creditScore.toFloat() / maxCreditScore.toFloat()) * FULL_ARC_ANGLE
    }

    private companion object {
        const val FULL_ARC_ANGLE = 360f
    }
}