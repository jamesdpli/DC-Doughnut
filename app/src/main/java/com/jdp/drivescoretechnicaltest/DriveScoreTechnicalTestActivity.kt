package com.jdp.drivescoretechnicaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.jdp.drivescoretechnicaltest.core.theme.DriveScoreTechnicalTestTheme
import com.jdp.drivescoretechnicaltest.core.navigation.DriveScoreTechnicalTestNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriveScoreTechnicalTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DriveScoreTechnicalTestTheme {
                val navHostController = rememberNavController()

                DriveScoreTechnicalTestNavHost(navHostController = navHostController)
            }
        }
    }
}

