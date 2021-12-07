package com.clouddjr.advent2021

import kotlin.math.abs

class Day07(input: String) {

    private val positions = input.split(",").map { it.toInt() }.sorted()

    fun solvePart1(): Int {
        val median = positions[positions.size / 2]
        return positions.sumOf { i -> abs(median - i) }
    }

    fun solvePart2(): Int {
        val average = positions.average().toInt()
        return (average..average + 1).minOf { pos ->
            positions.sumOf { i -> ((1 + abs(pos - i)) * abs(pos - i) / 2) }
        }
    }
}