package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 6")
class Day06Test {

    private val input =
        """
           3,4,3,1,2
        """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart1()

            assertEquals(5934, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsText("day06.txt")).solvePart1()

            assertEquals(385_391, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart2()

            assertEquals(26_984_457_539, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsText("day06.txt")).solvePart2()

            assertEquals(1_728_611_055_389, answer)
        }
    }
}