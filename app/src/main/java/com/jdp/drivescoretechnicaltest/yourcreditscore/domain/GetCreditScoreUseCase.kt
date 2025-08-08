package com.jdp.drivescoretechnicaltest.yourcreditscore.domain

import javax.inject.Inject

class GetCreditScoreUseCase @Inject constructor(
    private val repository: YourCreditScoreRepository
) {
    suspend operator fun  invoke() = repository.getYourCreditScore()
}