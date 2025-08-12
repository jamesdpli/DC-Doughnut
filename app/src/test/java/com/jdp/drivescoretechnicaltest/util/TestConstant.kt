package com.jdp.drivescoretechnicaltest.util

import com.jdp.drivescoretechnicaltest.core.network.service.model.YourCreditScoreNetworkResponse

object TestConstant {
    private val PLACE_HOLDER_TEXT = "place_holder_text"
    private val MAX_CREDIT_SCORE = 1000
    private val YOUR_CREDIT_SCORE = 800
    private val PLACE_HOLDER_INT = 20
    private val creditReportInfo = YourCreditScoreNetworkResponse.CreditReportInfo(
        changeInLongTermDebt = PLACE_HOLDER_INT,
        changeInShortTermDebt = PLACE_HOLDER_INT,
        changedScore = PLACE_HOLDER_INT,
        clientRef = PLACE_HOLDER_TEXT,
        currentLongTermCreditLimit = PLACE_HOLDER_TEXT,
        currentLongTermCreditUtilisation = PLACE_HOLDER_TEXT,
        currentLongTermDebt = PLACE_HOLDER_INT,
        currentLongTermNonPromotionalDebt = PLACE_HOLDER_INT,
        currentShortTermCreditLimit = 10,
        currentShortTermCreditUtilisation = PLACE_HOLDER_INT,
        currentShortTermDebt = PLACE_HOLDER_INT,
        currentShortTermNonPromotionalDebt = PLACE_HOLDER_INT,
        daysUntilNextReport = PLACE_HOLDER_INT,
        equifaxScoreBand = PLACE_HOLDER_INT,
        equifaxScoreBandDescription = PLACE_HOLDER_TEXT,
        hasEverBeenDelinquent = true,
        hasEverDefaulted = true,
        maxScoreValue = MAX_CREDIT_SCORE,
        minScoreValue = PLACE_HOLDER_INT,
        monthsSinceLastDefaulted = PLACE_HOLDER_INT,
        monthsSinceLastDelinquent = PLACE_HOLDER_INT,
        numNegativeScoreFactors = PLACE_HOLDER_INT,
        numPositiveScoreFactors = PLACE_HOLDER_INT,
        percentageCreditUsed = PLACE_HOLDER_INT,
        percentageCreditUsedDirectionFlag = PLACE_HOLDER_INT,
        score = YOUR_CREDIT_SCORE,
        scoreBand = PLACE_HOLDER_INT,
        status = PLACE_HOLDER_TEXT
    )
    private val coachingSummary = YourCreditScoreNetworkResponse.CoachingSummary(
        activeChat = true,
        activeTodo = true,
        numberOfCompletedTodoItems = PLACE_HOLDER_INT,
        numberOfTodoItems = PLACE_HOLDER_INT,
        selected = true
    )
    val yourCreditScoreNetworkResponse = YourCreditScoreNetworkResponse(
        accountIDVStatus = PLACE_HOLDER_TEXT,
        augmentedCreditScore = PLACE_HOLDER_INT,
        coachingSummary = coachingSummary,
        creditReportInfo = creditReportInfo,
        dashboardStatus = PLACE_HOLDER_TEXT,
        personaType = PLACE_HOLDER_TEXT
    )
}