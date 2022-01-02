package com.example.moviereservateservice.domain

import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
    private val movieTye: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double
) {

    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening)) fee.minus(calculateDiscountAmount()) else fee
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.any { it.isSatisfiedBy(screening) }
    }

    private fun calculateDiscountAmount(): Money {
        return when (movieTye) {
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountAmount()
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountAmount()
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountAmount()
        }
    }

    private fun calculateAmountDiscountAmount(): Money {
        return discountAmount
    }

    private fun calculatePercentDiscountAmount(): Money {
        return fee.times(discountPercent)
    }

    private fun calculateNoneDiscountAmount(): Money {
        return Money.ZERO
    }
}

enum class MovieType {
    AMOUNT_DISCOUNT,
    PERCENT_DISCOUNT,
    NONE_DISCOUNT
}
