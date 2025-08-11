package com.jdp.drivescoretechnicaltest.yourcreditscore.domain.usecase

import com.jdp.drivescoretechnicaltest.yourcreditscore.domain.repository.YourCreditScoreRepository
import javax.inject.Inject

class GetCreditScoreUseCase @Inject constructor(
    private val repository: YourCreditScoreRepository
) {
    suspend operator fun  invoke() = repository.getYourCreditScore()
}