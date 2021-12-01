package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsListOfInt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
class Day01Test {

    private val input =
        """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
        """.trimIndent().lines().map { it.toInt() }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart1()

            assertEquals(7, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfInt("day01.txt")).solvePart1()

            assertEquals(1393, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart2()

            assertEquals(5, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfInt("day01.txt")).solvePart2()

            assertEquals(1359, answer)
        }
    }
}