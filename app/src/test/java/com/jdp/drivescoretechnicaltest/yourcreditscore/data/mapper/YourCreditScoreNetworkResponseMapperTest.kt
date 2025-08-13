package com.jdp.drivescoretechnicaltest.yourcreditscore.data.mapper

import com.jdp.drivescoretechnicaltest.util.TestConstant
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel
import org.junit.Assert.assertEquals
import org.junit.Test

class YourCreditScoreNetworkResponseMapperTest {

    private val mapper = YourCreditScoreNetworkResponseMapper()

    @Test
    fun `GIVEN a network response WHEN map is called expect a domain model returned`() {
        val actual = mapper.map(networkResponse = TestConstant.yourCreditScoreNetworkResponse)
        val expected = YourCreditScoreDomainModel(
            creditScore = YOUR_CREDIT_SCORE,
            maxCreditScore = MAX_CREDIT_SCORE
        )

        assertEquals(expected, actual)
    }

    private companion object {
        const val MAX_CREDIT_SCORE = 1000
        const val YOUR_CREDIT_SCORE = 800
    }
}
