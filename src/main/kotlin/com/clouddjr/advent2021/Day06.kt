package com.clouddjr.advent2021

class Day06(input: String) {

    private val numbers = input.split(",").map { it.toInt() }

    fun solvePart1() = simulate(80)
    fun solvePart2() = simulate(256)

    private val cache = mutableMapOf<Int, Long>()

    private fun simulate(endDay: Int): Long {
        return numbers.sumOf { n -> 1 + (n + 1..endDay step 7).sumOf { i -> 1 + created(i, endDay) } }
    }

    private fun created(startDay: Int, endDay: Int): Long {
        return ((startDay + 8 + 1)..endDay step 7).sumOf { i -> cache.getOrPut(i) { 1 + created(i, endDay) } }
    }
}