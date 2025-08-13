package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.jdp.drivescoretechnicaltest.yourcreditscore.util.TestTag

@Composable
fun YourCreditScoreLoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.testTag(tag = TestTag.YOUR_CREDIT_SCORE_PROGRESS_SPINNER)
        )
    }
}