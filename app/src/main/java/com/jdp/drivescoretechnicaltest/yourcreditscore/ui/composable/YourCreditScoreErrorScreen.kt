package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jdp.drivescoretechnicaltest.R
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel.YourCreditScoreIntent

@Composable
fun YourCreditScoreErrorScreen(
    intentHandler: (YourCreditScoreIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.your_credit_score_error_message),
                modifier = Modifier.padding(all= 16.dp)
            )
        }
        Button(
            onClick = { intentHandler(YourCreditScoreIntent.OnTryAgainClick) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.try_again_button_title))
        }
    }
}