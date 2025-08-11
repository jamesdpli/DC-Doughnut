package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.state.YourCreditScoreUIState

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun YourCreditScoreScreen(uiState: YourCreditScoreUIState) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Your credit score") })
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        when (uiState) {
            YourCreditScoreUIState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues = innerPadding)
                ) {
                    CircularProgressIndicator()
                }
            }
            is YourCreditScoreUIState.Success -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues = innerPadding)
                ) {
                    Text(text = (uiState.data.creditScore.toString()))
                }
            }
            YourCreditScoreUIState.Error -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues = innerPadding)
                ) {
                    Text(text = "Error")
                }
            }
        }
    }
}