package com.jdp.drivescoretechnicaltest.yourcreditscore.ui

import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.YourCreditScoreDomainModel

sealed interface YourCreditScoreUIState {
    data object Loading : YourCreditScoreUIState
    data class Success(val data: YourCreditScoreDomainModel) : YourCreditScoreUIState
    data object Error : YourCreditScoreUIState
}