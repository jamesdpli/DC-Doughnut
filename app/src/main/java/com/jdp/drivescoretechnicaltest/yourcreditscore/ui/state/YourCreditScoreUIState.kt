package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.state

import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.model.YourCreditScoreDomainModel

sealed interface YourCreditScoreUIState {
    data object Loading : YourCreditScoreUIState
    data class Success(val data: YourCreditScoreDomainModel) : YourCreditScoreUIState
    data object Error : YourCreditScoreUIState
}