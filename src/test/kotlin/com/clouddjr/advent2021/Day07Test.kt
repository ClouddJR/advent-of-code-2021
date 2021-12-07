package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 7")
class Day07Test {

    private val input = """
        16,1,2,0,4,2,7,1,2,14
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart1()

            assertEquals(37, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsText("day07.txt")).solvePart1()

            assertEquals(336_721, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart2()

            assertEquals(168, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsText("day07.txt")).solvePart2()

            assertEquals(91_638_945, answer)
        }
    }
}