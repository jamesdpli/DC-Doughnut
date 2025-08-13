package com.jdp.drivescoretechnicaltest.core.network.service

import com.jdp.drivescoretechnicaltest.core.network.service.model.YourCreditScoreNetworkResponse
import com.jdp.drivescoretechnicaltest.core.network.util.NetworkConstant
import retrofit2.http.GET

interface YourCreditScoreService {
    @GET(value = NetworkConstant.YOUR_CREDIT_SCORE_END_POINT)
    suspend fun getYourCreditScore(): YourCreditScoreNetworkResponse
}