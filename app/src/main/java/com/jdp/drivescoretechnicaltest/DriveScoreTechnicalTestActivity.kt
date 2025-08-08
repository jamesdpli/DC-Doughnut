package com.jdp.drivescoretechnicaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jdp.drivescoretechnicaltest.core.theme.DriveScoreTechnicalTestTheme
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.YourCreditScoreScreen
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.YourCreditScoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriveScoreTechnicalTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DriveScoreTechnicalTestTheme {
                val vm: YourCreditScoreViewModel = hiltViewModel()
                val uiState by vm.uiState.collectAsStateWithLifecycle()

                YourCreditScoreScreen(uiState = uiState)
            }
        }
    }
}

