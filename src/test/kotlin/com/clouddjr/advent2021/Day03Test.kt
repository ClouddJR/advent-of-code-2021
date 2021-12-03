package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
class Day03Test {

    private val input =
        """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart1()

            assertEquals(198, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsList("day03.txt")).solvePart1()

            assertEquals(2_640_986, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart2()

            assertEquals(230, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsList("day03.txt")).solvePart2()

            assertEquals(6_822_109, answer)
        }
    }
}