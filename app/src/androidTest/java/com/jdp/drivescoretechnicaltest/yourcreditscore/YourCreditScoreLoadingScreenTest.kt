package com.jdp.drivescoretechnicaltest.yourcreditscore

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jdp.drivescoretechnicaltest.core.theme.DriveScoreTechnicalTestTheme
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable.YourCreditScoreScreen
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreUIState
import com.jdp.drivescoretechnicaltest.yourcreditscore.util.TestTag
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class YourCreditScoreLoadingScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun given_UI_state_is_loading_when_screen_displayed_then_expect_UI_elements_shown() {
        composeTestRule.setContent {
            DriveScoreTechnicalTestTheme {
                YourCreditScoreScreen(
                    uiState = YourCreditScoreUIState.Loading,
                    intentHandler = {}
                )
            }
        }
        composeTestRule
            .onNodeWithTag(testTag = TestTag.YOUR_CREDIT_SCORE_PROGRESS_SPINNER)
            .assertIsDisplayed()
    }
}