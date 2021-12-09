package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 9")
class Day09Test {

    private val input = """
        2199943210
        3987894921
        9856789892
        8767896789
        9899965678
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart1()

            assertEquals(15, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsList("day09.txt")).solvePart1()

            assertEquals(560, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart2()

            assertEquals(1134, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsList("day09.txt")).solvePart2()

            assertEquals(959_136, answer)
        }
    }
}