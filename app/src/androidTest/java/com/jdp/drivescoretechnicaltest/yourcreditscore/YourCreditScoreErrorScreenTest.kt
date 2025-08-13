package com.jdp.drivescoretechnicaltest.yourcreditscore

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jdp.drivescoretechnicaltest.core.theme.DriveScoreTechnicalTestTheme
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable.YourCreditScoreErrorScreen
import com.jdp.drivescoretechnicaltest.yourcreditscore.util.TestTag.YOUR_CREDIT_SCORE_ERROR_CARD
import com.jdp.drivescoretechnicaltest.yourcreditscore.util.TestTag.YOUR_CREDIT_SCORE_ERROR_TRY_AGAIN_BUTTON
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class YourCreditScoreErrorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun your_credit_score_error_screen_test() {
        composeTestRule.setContent {
            DriveScoreTechnicalTestTheme {
                YourCreditScoreErrorScreen(intentHandler = {})
            }
        }
        with(receiver = composeTestRule) {
            onNodeWithTag(testTag = YOUR_CREDIT_SCORE_ERROR_CARD).assertIsDisplayed()
            onNodeWithTag(testTag = YOUR_CREDIT_SCORE_ERROR_TRY_AGAIN_BUTTON).assertIsDisplayed()
        }
    }
}