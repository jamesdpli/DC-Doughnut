package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.mapper

import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.model.YourCreditScoreUIModel
import org.junit.Assert.assertEquals
import org.junit.Test

class YourCreditScoreDomainModelMapperTest {

    private val mapper = YourCreditScoreDomainModelMapper()

    @Test
    fun `GIVEN a domain model WHEN map THEN expect a UI model returned`() {
        val domainModel = YourCreditScoreDomainModel(
            creditScore = YOUR_CREDIT_SCORE,
            maxCreditScore = MAX_CREDIT_SCORE
        )

        val actual = mapper.map(domainModel = domainModel)
        val expected = YourCreditScoreUIModel(
            creditScore = YOUR_CREDIT_SCORE_UI_MODEL,
            maxCreditScore = MAX_CREDIT_SCORE_UI_MODEL,
            doughnutSweepAngle = DOUGHNUT_SWEEP_ANGLE
        )

        assertEquals(expected, actual)
    }

    private companion object {
        const val YOUR_CREDIT_SCORE = 100
        const val YOUR_CREDIT_SCORE_UI_MODEL = "100"
        const val MAX_CREDIT_SCORE = 100
        const val MAX_CREDIT_SCORE_UI_MODEL = "100"
        const val DOUGHNUT_SWEEP_ANGLE = 360f
    }
}