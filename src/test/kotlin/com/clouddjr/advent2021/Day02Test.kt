package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 2")
class Day02Test {

    private val input =
        """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart1()

            assertEquals(150, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsList("day02.txt")).solvePart1()

            assertEquals(1_714_950, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
                val answer = Day02(input).solvePart2()

            assertEquals(900, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsList("day02.txt")).solvePart2()

            assertEquals(1_281_977_850, answer)
        }
    }
}