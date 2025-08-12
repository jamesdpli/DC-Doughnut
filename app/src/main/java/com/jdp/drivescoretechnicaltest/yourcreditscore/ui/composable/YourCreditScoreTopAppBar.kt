package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import com.jdp.drivescoretechnicaltest.R

@Composable
@OptIn(markerClass = [ExperimentalMaterial3Api::class])
fun YourCreditScoreTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.your_credit_score_top_app_bar_title),
                modifier = Modifier.semantics {
                    heading()
                }
            )
        }
    )
}