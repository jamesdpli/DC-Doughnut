package com.jdp.drivescoretechnicaltest.yourcreditscore

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jdp.drivescoretechnicaltest.core.theme.DriveScoreTechnicalTestTheme
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable.YourCreditScoreScreen
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
    fun given_UI_state_is_success_when_screen_displayed_then_expect_UI_elements_shown() {
        composeTestRule.setContent {
            DriveScoreTechnicalTestTheme {
                YourCreditScoreScreen(
                    uiState = YourCreditScoreUIState.Success(
                        data = YourCreditScoreUIModel(
                            creditScore = YOUR_CREDIT_SCORE,
                            maxCreditScore = MAX_CREDIT_SCORE,
                            doughnutSweepAngle = DOUGHNUT_SWEEP_ANGLE
                        )
                    ),
                    intentHandler = {}
                )
            }
        }
        with(receiver = composeTestRule) {
            onNodeWithTag(testTag = YOUR_CREDIT_SCORE_DOUGHNUT)
                .assertIsDisplayed()
                .assertContentDescriptionContains(value = DOUGHNUT_CONTENT_DESCRIPTION)
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
        const val DOUGHNUT_CONTENT_DESCRIPTION = "Your credit score is 100 out of 100"
        const val YOUR_CREDIT_SCORE_TOTAL_EXPECTED_VALUE = "out of 100"
    }
}