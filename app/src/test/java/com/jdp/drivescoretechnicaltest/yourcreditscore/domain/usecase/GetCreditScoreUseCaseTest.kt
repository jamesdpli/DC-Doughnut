package com.jdp.drivescoretechnicaltest.yourcreditscore.domain.usecase

import com.jdp.drivescoretechnicaltest.core.network.Resource
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.repository.YourCreditScoreRepository
import io.mockk.coEvery
import io.mockk.mockk
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import kotlinx.coroutines.test.runTest
import okio.IOException
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = JUnitParamsRunner::class)
class GetCreditScoreUseCaseTest {

    private val repository: YourCreditScoreRepository = mockk()

    private val useCase = GetCreditScoreUseCase(repository = repository)

    @Test
    @Parameters(method = "getParamsForUseCaseTest")
    @TestCaseName(
        "GIVEN repository response is {0} WHEN use case is invoked THEN expect result to be {1}"
    )
    fun `GIVEN a repository response WHEN the use case is invoked THEN expect a result`(
        repositoryResponse: Resource<YourCreditScoreDomainModel>,
        expected: Resource<YourCreditScoreDomainModel>,
    ) = runTest {
        coEvery { repository.getYourCreditScore() } returns repositoryResponse

        val actual = useCase()

        assertEquals(expected, actual)
    }

    private fun getParamsForUseCaseTest() = arrayOf(
        arrayOf(
            Resource.Success(
                data = YourCreditScoreDomainModel(
                    creditScore = YOUR_CREDIT_SCORE,
                    maxCreditScore = MAX_CREDIT_SCORE
                )
            ),
            Resource.Success(
                data = YourCreditScoreDomainModel(
                    creditScore = YOUR_CREDIT_SCORE,
                    maxCreditScore = MAX_CREDIT_SCORE
                )
            )
        ),
        arrayOf(
            Resource.Error(exception = exception),
            Resource.Error(exception = exception),
        )
    )

    private companion object {
        const val YOUR_CREDIT_SCORE = 100
        const val MAX_CREDIT_SCORE = 100
        val exception = IOException()
    }
}