package com.clouddjr.advent2021

class Day03(private val input: List<String>) {

    fun solvePart1(): Int {
        val gamma = input.map { number -> number.toList().map { it.toString() } }
            .reduce { first, second -> first.zip(second).map { it.first + it.second } }
            .joinToString("") { bitRow -> if (bitRow.count { it == '1' } > bitRow.length / 2) "1" else "0" }

        val epsilon = gamma.map { (1 - it.digitToInt()) }.joinToString("")

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun solvePart2(): Int {
        val oxygen = (0 until input.first().length).fold(input) { filtered, position ->
            val mostCommon = filtered.findCommonAtPosition(leastCommon = false, position)

            if (filtered.size == 1) filtered else filtered.filter { it[position] == mostCommon }
        }.single()

        val co2 = (0 until input.first().length).fold(input) { filtered, position ->
            val leastCommon = filtered.findCommonAtPosition(leastCommon = true, position)

            if (filtered.size == 1) filtered else filtered.filter { it[position] == leastCommon }
        }.single()

        return oxygen.toInt(2) * co2.toInt(2)
    }

    private fun List<String>.findCommonAtPosition(leastCommon: Boolean, position: Int): Char {
        return count { it[position] == '1' }
            .let { if (it >= size - it) '1' else '0' }
            .let { if (leastCommon) (1 - it.digitToInt()).digitToChar() else it }
    }
}