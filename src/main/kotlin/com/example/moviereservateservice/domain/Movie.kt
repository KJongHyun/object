package com.example.moviereservateservice.domain

import java.time.Duration

abstract class Movie(
    private val title: String,
    private val runningTime: Duration,
    protected val fee: Money,
    private val discountConditions: List<DiscountCondition>
) {

    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening)) fee.minus(calculateDiscountAmount()) else fee
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.any { it.isSatisfiedBy(screening) }
    }

    protected abstract fun calculateDiscountAmount(): Money
}
