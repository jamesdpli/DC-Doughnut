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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.jdp.drivescoretechnicaltest.R
import com.jdp.drivescoretechnicaltest.core.theme.Typography
import com.jdp.drivescoretechnicaltest.core.util.invisibleToUser
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreUIState
import com.jdp.drivescoretechnicaltest.yourcreditscore.util.TestTag

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
) = with(receiver = uiState.data) {
    val doughnutAccessibilityDescription = stringResource(
        id = R.string.your_credit_score_accessibility_doughnut,
        formatArgs = arrayOf(
            uiState.data.creditScore,
            uiState.data.maxCreditScore
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 300.dp)
            .testTag(tag = TestTag.YOUR_CREDIT_SCORE_DOUGHNUT)
            .semantics {
                contentDescription = doughnutAccessibilityDescription
            }
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .invisibleToUser(mergeDescendants = true)
        ) {
            rotate(degrees = DoughnutDefaults.CANVAS_ROTATION) {
                drawArc(
                    color = Color.Gray,
                    startAngle = DoughnutDefaults.ARC_START_ANGLE,
                    sweepAngle = DoughnutDefaults.FULL_ARC_SWEEP_ANGLE,
                    useCenter = false,
                    style = Stroke(width = DoughnutDefaults.OUTER_ARC_STROKE_WIDTH)

                )
                inset(inset = DoughnutDefaults.INNER_ARC_INSET) {
                    drawArc(
                        brush = Brush.sweepGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Yellow,
                                Color.Green
                            )
                        ),
                        startAngle = DoughnutDefaults.ARC_START_ANGLE,
                        sweepAngle = doughnutSweepAngle,
                        useCenter = false,
                        style = Stroke(
                            width = DoughnutDefaults.INNER_ARC_STROKE_WIDTH,
                            cap = StrokeCap.Butt
                        )
                    )
                }
            }
        }
        DonutInformation(uiState = uiState)
    }
}

@Composable
private fun DonutInformation(
    uiState: YourCreditScoreUIState.Success
) = with(receiver = uiState.data) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 15.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.your_credit_score_doughnut_title),
            modifier = Modifier.invisibleToUser()
        )
        Text(
            text = creditScore,
            fontSize = Typography.displayLarge.fontSize,
            modifier = Modifier.invisibleToUser()
        )
        Text(
            text = stringResource(
                id = R.string.your_credit_score_doughnut_score_total,
                formatArgs = arrayOf(maxCreditScore)
            ),
            modifier = Modifier.invisibleToUser()
        )
    }
}

private object DoughnutDefaults {
    const val CANVAS_ROTATION = 180f
    const val FULL_ARC_SWEEP_ANGLE = 360f
    const val ARC_START_ANGLE = 0f
    const val INNER_ARC_INSET = 30f
    const val OUTER_ARC_STROKE_WIDTH = 10f
    const val INNER_ARC_STROKE_WIDTH = 16f
}