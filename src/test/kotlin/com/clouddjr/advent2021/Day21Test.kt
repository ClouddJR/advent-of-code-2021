package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 21")
class Day21Test {

    private val input = """
        Player 1 starting position: 4
        Player 2 starting position: 8
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day21(input).solvePart1()

            assertEquals(739785, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day21(resourceAsList("day21.txt")).solvePart1()

            assertEquals(679329, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day21(input).solvePart2()

            assertEquals(444_356_092_776_315, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day21(resourceAsList("day21.txt")).solvePart2()

            assertEquals(433_315_766_324_816, answer)
        }
    }
}