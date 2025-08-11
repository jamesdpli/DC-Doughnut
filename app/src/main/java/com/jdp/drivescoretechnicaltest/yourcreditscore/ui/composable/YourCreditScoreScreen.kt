package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.state.YourCreditScoreUIState

@Composable
@OptIn(markerClass = [ExperimentalMaterial3Api::class])
fun YourCreditScoreScreen(uiState: YourCreditScoreUIState) {
    Scaffold(
        topBar = {
            YourCreditScoreTopAppBar()
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        when (uiState) {
            YourCreditScoreUIState.Loading -> {
                YourCreditScoreLoadingScreen(
                    modifier = Modifier.padding(paddingValues = innerPadding)
                )
            }
            is YourCreditScoreUIState.Success -> {
                YourCreditScoreSuccessScreen(
                    uiState = uiState,
                    modifier = Modifier.padding(paddingValues = innerPadding)
                )
            }
            YourCreditScoreUIState.Error -> {
                YourCreditScoreErrorScreen(
                    modifier = Modifier.padding(paddingValues = innerPadding)
                )
            }
        }
    }
}
