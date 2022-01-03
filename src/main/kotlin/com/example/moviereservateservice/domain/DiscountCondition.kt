package com.example.moviereservateservice.domain

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return this.dayOfWeek == screening.whenScreened.dayOfWeek && this.startTime <= screening.whenScreened.toLocalTime() && this.endTime >= screening.whenScreened.toLocalTime()
    }
}

class SequenceCondition(
    private val sequence: Int
) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return this.sequence == screening.sequence
    }
}
