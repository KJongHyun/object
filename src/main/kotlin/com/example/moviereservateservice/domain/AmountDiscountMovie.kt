package com.example.moviereservateservice.domain

import java.time.Duration

class AmountDiscountMovie(
    private val discountAmount: Money,
    title: String,
    runningTime: Duration,
    money: Money,
    discountConditions: List<DiscountCondition>
) : Movie(title, runningTime, money, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}