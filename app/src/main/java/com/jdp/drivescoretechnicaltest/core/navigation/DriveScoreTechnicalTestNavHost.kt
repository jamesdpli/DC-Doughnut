package com.jdp.drivescoretechnicaltest.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable.YourCreditScoreScreen
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreIntent
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreViewModel
import kotlinx.serialization.Serializable

@Serializable
object YourCreditScoreScreen

@Composable
fun DriveScoreTechnicalTestNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = YourCreditScoreScreen
    ) {
        composable<YourCreditScoreScreen> {
            val viewModel: YourCreditScoreViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = Unit) {
                viewModel.handleIntent(intent = YourCreditScoreIntent.Load)
            }

            YourCreditScoreScreen(
                uiState = uiState,
                intentHandler = viewModel::handleIntent
            )
        }
    }
}