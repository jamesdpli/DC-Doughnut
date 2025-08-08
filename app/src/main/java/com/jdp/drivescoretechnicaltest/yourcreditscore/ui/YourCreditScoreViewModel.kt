package com.jdp.drivescoretechnicaltest.yourcreditscore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdp.drivescoretechnicaltest.core.network.Resource
import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.GetCreditScoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YourCreditScoreViewModel @Inject constructor(
    private val getCreditScoreUseCase: GetCreditScoreUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<YourCreditScoreUIState>(
        value = YourCreditScoreUIState.Loading
    )
    val uiState = _uiState.asStateFlow()

    init {
        getCreditScore()
    }

    private fun getCreditScore() = viewModelScope.launch {
        when (val response = getCreditScoreUseCase()) {
            is Resource.Success -> {
                _uiState.update {
                    YourCreditScoreUIState.Success(data= response.data)
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