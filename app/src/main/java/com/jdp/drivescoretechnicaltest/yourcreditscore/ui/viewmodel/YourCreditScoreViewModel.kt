package com.jdp.drivescoretechnicaltest.yourcreditscore.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdp.drivescoretechnicaltest.core.network.Resource
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.usecase.GetCreditScoreUseCase
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.mapper.YourCreditScoreDomainModelMapper
import com.jdp.drivescoretechnicaltest.yourcreditscore.ui.model.YourCreditScoreUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface YourCreditScoreIntent {
    data object OnTryAgainClick : YourCreditScoreIntent
}

sealed interface YourCreditScoreUIState {
    data object Loading : YourCreditScoreUIState
    data class Success(val data: YourCreditScoreUIModel) : YourCreditScoreUIState
    data object Error : YourCreditScoreUIState
}

@HiltViewModel
class YourCreditScoreViewModel @Inject constructor(
    private val getCreditScoreUseCase: GetCreditScoreUseCase,
    private val yourCreditScoreDomainModelMapper: YourCreditScoreDomainModelMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<YourCreditScoreUIState>(
        value = YourCreditScoreUIState.Loading
    )
    val uiState = _uiState.asStateFlow()

    init {
        getCreditScore()
    }

    fun handleIntent(intent: YourCreditScoreIntent) = when (intent) {
        is YourCreditScoreIntent.OnTryAgainClick -> {
            getCreditScore()
        }
    }

    private fun getCreditScore() = viewModelScope.launch {
        when (val response = getCreditScoreUseCase()) {
            is Resource.Success -> {
                _uiState.update {
                    YourCreditScoreUIState.Success(
                        data = yourCreditScoreDomainModelMapper.map(
                            domainModel = response.data
                        )
                    )
                }
            }
            is Resource.Error -> {
                _uiState.update {
                    YourCreditScoreUIState.Error
                }
            }
        }
    }

}