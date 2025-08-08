package com.jdp.drivescoretechnicaltest.core.network.service.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class YourCreditScoreNetworkResponse(
    @Json(name = "accountIDVStatus")
    val accountIDVStatus: String,
    @Json(name = "augmentedCreditScore")
    val augmentedCreditScore: Any?,
    @Json(name = "coachingSummary")
    val coachingSummary: CoachingSummary,
    @Json(name = "creditReportInfo")
    val creditReportInfo: CreditReportInfo,
    @Json(name = "dashboardStatus")
    val dashboardStatus: String,
    @Json(name = "personaType")
    val personaType: String
) {
    @JsonClass(generateAdapter = true)
    data class CoachingSummary(
        @Json(name = "activeChat")
        val activeChat: Boolean,
        @Json(name = "activeTodo")
        val activeTodo: Boolean,
        @Json(name = "numberOfCompletedTodoItems")
        val numberOfCompletedTodoItems: Int,
        @Json(name = "numberOfTodoItems")
        val numberOfTodoItems: Int,
        @Json(name = "selected")
        val selected: Boolean
    )

    @JsonClass(generateAdapter = true)
    data class CreditReportInfo(
        @Json(name = "changeInLongTermDebt")
        val changeInLongTermDebt: Int,
        @Json(name = "changeInShortTermDebt")
        val changeInShortTermDebt: Int,
        @Json(name = "changedScore")
        val changedScore: Int,
        @Json(name = "clientRef")
        val clientRef: String,
        @Json(name = "currentLongTermCreditLimit")
        val currentLongTermCreditLimit: Any?,
        @Json(name = "currentLongTermCreditUtilisation")
        val currentLongTermCreditUtilisation: Any?,
        @Json(name = "currentLongTermDebt")
        val currentLongTermDebt: Int,
        @Json(name = "currentLongTermNonPromotionalDebt")
        val currentLongTermNonPromotionalDebt: Int,
        @Json(name = "currentShortTermCreditLimit")
        val currentShortTermCreditLimit: Int,
        @Json(name = "currentShortTermCreditUtilisation")
        val currentShortTermCreditUtilisation: Int,
        @Json(name = "currentShortTermDebt")
        val currentShortTermDebt: Int,
        @Json(name = "currentShortTermNonPromotionalDebt")
        val currentShortTermNonPromotionalDebt: Int,
        @Json(name = "daysUntilNextReport")
        val daysUntilNextReport: Int,
        @Json(name = "equifaxScoreBand")
        val equifaxScoreBand: Int,
        @Json(name = "equifaxScoreBandDescription")
        val equifaxScoreBandDescription: String,
        @Json(name = "hasEverBeenDelinquent")
        val hasEverBeenDelinquent: Boolean,
        @Json(name = "hasEverDefaulted")
        val hasEverDefaulted: Boolean,
        @Json(name = "maxScoreValue")
        val maxScoreValue: Int,
        @Json(name = "minScoreValue")
        val minScoreValue: Int,
        @Json(name = "monthsSinceLastDefaulted")
        val monthsSinceLastDefaulted: Int,
        @Json(name = "monthsSinceLastDelinquent")
        val monthsSinceLastDelinquent: Int,
        @Json(name = "numNegativeScoreFactors")
        val numNegativeScoreFactors: Int,
        @Json(name = "numPositiveScoreFactors")
        val numPositiveScoreFactors: Int,
        @Json(name = "percentageCreditUsed")
        val percentageCreditUsed: Int,
        @Json(name = "percentageCreditUsedDirectionFlag")
        val percentageCreditUsedDirectionFlag: Int,
        @Json(name = "score")
        val score: Int,
        @Json(name = "scoreBand")
        val scoreBand: Int,
        @Json(name = "status")
        val status: String
    )
}
