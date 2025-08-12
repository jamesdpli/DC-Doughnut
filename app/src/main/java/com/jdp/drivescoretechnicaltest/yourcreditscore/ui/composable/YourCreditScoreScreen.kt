package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreIntent
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreUIState

@Composable
@OptIn(markerClass = [ExperimentalMaterial3Api::class])
fun YourCreditScoreScreen(
    uiState: YourCreditScoreUIState,
    intentHandler: (YourCreditScoreIntent) -> Unit
) {
    Scaffold(
        topBar = {
            YourCreditScoreTopAppBar()
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Crossfade(targetState = uiState) { targetState ->
            when (targetState) {
                YourCreditScoreUIState.Loading -> {
                    YourCreditScoreLoadingScreen(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
                is YourCreditScoreUIState.Success -> {
                    YourCreditScoreSuccessScreen(
                        uiState = targetState,
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
                YourCreditScoreUIState.Error -> {
                    YourCreditScoreErrorScreen(
                        intentHandler = intentHandler,
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}
