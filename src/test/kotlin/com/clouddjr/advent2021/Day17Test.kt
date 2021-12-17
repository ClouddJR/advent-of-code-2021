package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 17")
class Day17Test {

    private val input = """
        target area: x=20..30, y=-10..-5
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day17(input).solvePart1()

            assertEquals(45, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsText("day17.txt")).solvePart1()

            assertEquals(3570, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day17(input).solvePart2()

            assertEquals(112, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsText("day17.txt")).solvePart2()

            assertEquals(1919, answer)
        }
    }
}