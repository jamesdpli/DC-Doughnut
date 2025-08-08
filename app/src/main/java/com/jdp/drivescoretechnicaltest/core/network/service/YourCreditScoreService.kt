package com.jdp.drivescoretechnicaltest.core.network.service

import com.jdp.drivescoretechnicaltest.core.network.service.model.YourCreditScoreNetworkResponse
import retrofit2.http.GET

interface YourCreditScoreService {
    @GET(value = "endpoint.json")
    suspend fun getYourCreditScore(): YourCreditScoreNetworkResponse
}