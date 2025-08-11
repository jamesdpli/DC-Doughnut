package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jdp.drivescoretechnicaltest.R
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.state.YourCreditScoreUIState

@Composable
fun YourCreditScoreSuccessScreen(
    uiState: YourCreditScoreUIState.Success,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Doughnut(uiState = uiState)
    }
}

@Composable
private fun Doughnut(
    uiState: YourCreditScoreUIState.Success
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(size = 300.dp)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawArc(
                color = Color.Gray,
                startAngle = -180f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 10f)
            )
            drawArc(
                color = Color.Red,
                startAngle = -180f,
                sweepAngle = ((uiState.data.creditScore/uiState.data.maxCreditScore) * 360.0).toFloat(),
                useCenter = false,
                style = Stroke(width = 20f)
            )
        }
        DonutInformation(uiState = uiState)
    }
}

@Composable
private fun DonutInformation(
    uiState: YourCreditScoreUIState.Success
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 15.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.your_credit_score_doughnut_title))
        Text(text = (uiState.data.creditScore.toString()))
        Text(
            text = stringResource(
                id = R.string.your_credit_score_doughnut_score_total,
                formatArgs = arrayOf(uiState.data.maxCreditScore)
            )
        )
    }
}