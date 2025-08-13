package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel

import app.cash.turbine.test
import com.jdp.drivescoretechnicaltest.core.network.Resource
import com.jdp.drivescoretechnicaltest.util.MainDispatcherRule
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.usecase.GetCreditScoreUseCase
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.mapper.YourCreditScoreDomainModelMapper
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.model.YourCreditScoreUIModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import kotlinx.coroutines.test.runTest
import okio.IOException
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = JUnitParamsRunner::class)
class YourCreditScoreViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val useCase: GetCreditScoreUseCase = mockk()
    private val yourCreditScoreDomainModelMapper: YourCreditScoreDomainModelMapper = mockk()

    private val domainModel = YourCreditScoreDomainModel(
        creditScore = YOUR_CREDIT_SCORE,
        maxCreditScore = MAX_CREDIT_SCORE
    )
    private val uiModel = YourCreditScoreUIModel(
        creditScore = UI_YOUR_CREDIT_SCORE,
        maxCreditScore = UI_MAX_CREDIT_SCORE,
        doughnutSweepAngle = SWEEP_ANGLE
    )
    private val ioException = IOException()

    private lateinit var viewModel: YourCreditScoreViewModel

    @Before
    fun setUp() {
        viewModel = YourCreditScoreViewModel(
            getCreditScoreUseCase = useCase,
            yourCreditScoreDomainModelMapper = yourCreditScoreDomainModelMapper
        )
    }

    @Test
    @Parameters(method = "getParamsForLoadIntentTest")
    @TestCaseName(
        value = "GIVEN useCase response: {0} WHEN intent is Load THEN expect UI state to be {1}"
    )
    fun `GIVEN a use case response WHEN intent is Load then expect UI state to be updated`(
        useCaseResponse: Resource<YourCreditScoreDomainModel>,
        expected: YourCreditScoreUIState,
        numberOfCallsToMapper: Int
    ) = runTest {
        coEvery { useCase() } returns useCaseResponse
        every { yourCreditScoreDomainModelMapper.map(domainModel = domainModel) } returns uiModel

        viewModel.uiState.test {
            awaitItem() // Wait for initial state

            viewModel.handleIntent(intent = YourCreditScoreIntent.Load) //Send Load intent
            val actual = awaitItem() //Capture the event we are expecting

            assertEquals(expected, actual)

            cancelAndConsumeRemainingEvents()
        }
        coVerify(exactly = numberOfCallsToMapper) {
            yourCreditScoreDomainModelMapper.map(domainModel = domainModel)
        }
    }

    @Test
    @Parameters(method = "getParamsForRefreshIntentTest")
    @TestCaseName(
        value = "GIVEN useCase response: {0} WHEN intent is Refresh THEN expect UI state to be {1}"
    )
    fun `GIVEN a use case response WHEN intent is Refresh then expect UI state to be updated`(
        useCaseResponse: Resource<YourCreditScoreDomainModel>,
        expected: YourCreditScoreUIState,
        numberOfCallsToMapper: Int
    ) = runTest {
        coEvery { useCase() } returns useCaseResponse
        every { yourCreditScoreDomainModelMapper.map(domainModel = domainModel) } returns uiModel

        viewModel.uiState.test {
            awaitItem() // Wait for initial state

            viewModel.handleIntent(intent = YourCreditScoreIntent.Refresh) //Send Refresh intent
            val actual = awaitItem() //Capture the event we are expecting

            assertEquals(expected, actual)

            cancelAndConsumeRemainingEvents()
        }
        coVerify(exactly = numberOfCallsToMapper) {
            yourCreditScoreDomainModelMapper.map(domainModel = domainModel)
        }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    private fun getParamsForLoadIntentTest() = arrayOf(
        arrayOf(
            Resource.Success(data = domainModel),
            YourCreditScoreUIState.Success(data = uiModel),
            1
        ),
        arrayOf(
            Resource.Error(exception = ioException),
            YourCreditScoreUIState.Error,
            0
        )
    )

    private fun getParamsForRefreshIntentTest() = arrayOf(
        arrayOf(
            Resource.Success(data = domainModel),
            YourCreditScoreUIState.Success(data = uiModel),
            1
        ),
        arrayOf(
            Resource.Error(exception = ioException),
            YourCreditScoreUIState.Error,
            0
        )
    )

    private companion object {
        const val MAX_CREDIT_SCORE = 100
        const val UI_MAX_CREDIT_SCORE = "100"
        const val YOUR_CREDIT_SCORE = 100
        const val UI_YOUR_CREDIT_SCORE = "100"
        const val SWEEP_ANGLE = 360f
    }
}