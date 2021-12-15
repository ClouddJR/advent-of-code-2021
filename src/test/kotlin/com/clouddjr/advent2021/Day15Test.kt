package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 15")
class Day15Test {

    private val input = """
        1163751742
        1381373672
        2136511328
        3694931569
        7463417111
        1319128137
        1359912421
        3125421639
        1293138521
        2311944581
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day15(input).solvePart1()

            assertEquals(40, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day15(resourceAsList("day15.txt")).solvePart1()

            assertEquals(592, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day15(input).solvePart2()

            assertEquals(315, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day15(resourceAsList("day15.txt")).solvePart2()

            assertEquals(2897, answer)
        }
    }
}