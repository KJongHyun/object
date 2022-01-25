package com.example.moviereservateservice.domain

import java.time.Duration

class PercentDiscountMovie(
    private val percent: Double,
    title: String,
    runningTime: Duration,
    fee: Money,
    discountConditions: List<DiscountCondition>
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return fee.times(percent)
    }
}