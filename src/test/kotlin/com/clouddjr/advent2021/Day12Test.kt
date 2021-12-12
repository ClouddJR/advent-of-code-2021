package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 12")
class Day12Test {

    private val input = """
        start-A
        start-b
        A-c
        A-b
        b-d
        A-end
        b-end
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day12(input).solvePart1()

            assertEquals(10, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsList("day12.txt")).solvePart1()

            assertEquals(5252, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day12(input).solvePart2()

            assertEquals(36, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsList("day12.txt")).solvePart2()

            assertEquals(147_784, answer)
        }
    }
}