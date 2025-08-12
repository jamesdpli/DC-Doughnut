package com.jdp.drivescoretechnicaltest.yourcreditscore.data.repository

import com.jdp.drivescoretechnicaltest.core.network.Resource
import com.jdp.drivescoretechnicaltest.core.network.service.YourCreditScoreService
import com.jdp.drivescoretechnicaltest.util.TestConstant
import com.jdp.drivescoretechnicaltest.yourcreditscore.data.mapper.YourCreditScoreNetworkResponseMapper
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okio.IOException
import org.junit.Assert.assertEquals
import org.junit.Test

class YourCreditScoreRepositoryImplTest {

    private val service: YourCreditScoreService = mockk()
    private val mapper: YourCreditScoreNetworkResponseMapper = mockk()

    private val repositoryImpl = YourCreditScoreRepositoryImpl(
        service = service,
        mapper = mapper
    )

    @Test
    fun `GIVEN api call success WHEN getYourCreditScore THEN expect a success resource returned`() =
        runTest {
            val domainModel = YourCreditScoreDomainModel(
                creditScore = YOUR_CREDIT_SCORE,
                maxCreditScore = MAX_CREDIT_SCORE
            )

            coEvery {
                service.getYourCreditScore()
            } returns TestConstant.yourCreditScoreNetworkResponse
            every {
                mapper.map(networkResponse = TestConstant.yourCreditScoreNetworkResponse)
            } returns domainModel

            val actual = repositoryImpl.getYourCreditScore()
            val expected = Resource.Success(data = domainModel)

            assertEquals(expected, actual)
        }

    @Test
    fun `GIVEN an api error WHEN getYourCreditScore THEN expect an error resource returned`() =
        runTest {
            val exception = IOException()
            coEvery { service.getYourCreditScore() } throws exception

            val actual = repositoryImpl.getYourCreditScore()
            val expected = Resource.Error(exception = exception)

            assertEquals(expected, actual)

        }

    private companion object {
        const val MAX_CREDIT_SCORE = 1000
        const val YOUR_CREDIT_SCORE = 800
    }

}