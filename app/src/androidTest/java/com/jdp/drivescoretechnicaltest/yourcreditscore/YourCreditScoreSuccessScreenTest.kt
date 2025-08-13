package com.jdp.drivescoretechnicaltest.yourcreditscore

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jdp.drivescoretechnicaltest.core.theme.DriveScoreTechnicalTestTheme
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable.YourCreditScoreSuccessScreen
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.model.YourCreditScoreUIModel
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreUIState
import com.jdp.drivescoretechnicaltest.yourcreditscore.util.TestTag.YOUR_CREDIT_SCORE_DOUGHNUT
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class YourCreditScoreSuccessScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun your_credit_score_success_screen_test() {
        composeTestRule.setContent {
            DriveScoreTechnicalTestTheme {
                YourCreditScoreSuccessScreen(
                    uiState = YourCreditScoreUIState.Success(
                        data = YourCreditScoreUIModel(
                            creditScore = YOUR_CREDIT_SCORE,
                            maxCreditScore = MAX_CREDIT_SCORE,
                            doughnutSweepAngle = DOUGHNUT_SWEEP_ANGLE
                        )
                    )
                )
            }
        }
        with(receiver = composeTestRule) {
            onNodeWithTag(testTag = YOUR_CREDIT_SCORE_DOUGHNUT)
                .assertIsDisplayed()
            onNodeWithText(text = YOUR_CREDIT_SCORE)
                .assertIsDisplayed()
            onNodeWithText(text = YOUR_CREDIT_SCORE_TOTAL_EXPECTED_VALUE)
                .assertIsDisplayed()
        }
    }

    private companion object {
        const val YOUR_CREDIT_SCORE = "100"
        const val MAX_CREDIT_SCORE = "100"
        const val DOUGHNUT_SWEEP_ANGLE = 360f
        const val YOUR_CREDIT_SCORE_TOTAL_EXPECTED_VALUE = "Out of 100"
    }
}