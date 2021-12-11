package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 11")
class Day11Test {

    private val input = """
        5483143223
        2745854711
        5264556173
        6141336146
        6357385478
        4167524645
        2176841721
        6882881134
        4846848554
        5283751526
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day11(input).solvePart1()

            assertEquals(1656, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsList("day11.txt")).solvePart1()

            assertEquals(1603, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day11(input).solvePart2()

            assertEquals(195, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsList("day11.txt")).solvePart2()

            assertEquals(222, answer)
        }
    }
}