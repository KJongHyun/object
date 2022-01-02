package com.example.moviereservateservice.domain

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {

    fun reserve() {

    }

    fun calculateFee(audienceCount: Int) {
        return movie.calculateMovieFee(this)
    }
}