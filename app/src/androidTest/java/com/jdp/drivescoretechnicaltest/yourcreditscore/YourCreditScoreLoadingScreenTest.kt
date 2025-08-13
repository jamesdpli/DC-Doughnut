package com.jdp.drivescoretechnicaltest.yourcreditscore

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jdp.drivescoretechnicaltest.core.theme.DriveScoreTechnicalTestTheme
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable.YourCreditScoreLoadingScreen
import com.jdp.drivescoretechnicaltest.yourcreditscore.util.TestTag
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class YourCreditScoreLoadingScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun your_credit_score_loading_screen_test() {
        composeTestRule.setContent {
            DriveScoreTechnicalTestTheme {
                YourCreditScoreLoadingScreen()
            }
        }
        composeTestRule
            .onNodeWithTag(testTag = TestTag.YOUR_CREDIT_SCORE_PROGRESS_SPINNER)
            .assertIsDisplayed()
    }
}