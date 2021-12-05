package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 5")
class Day05Test {

    private val input =
        """
            0,9 -> 5,9
            8,0 -> 0,8
            9,4 -> 3,4
            2,2 -> 2,1
            7,0 -> 7,4
            6,4 -> 2,0
            0,9 -> 2,9
            3,4 -> 1,4
            0,0 -> 8,8
            5,5 -> 8,2
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart1()

            assertEquals(5, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsList("day05.txt")).solvePart1()

            assertEquals(5690, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart2()

            assertEquals(12, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsList("day05.txt")).solvePart2()

            assertEquals(17741, answer)
        }
    }
}