package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 16")
class Day16Test {

    private val inputPart1 = """
        A0016C880162017C3686B18A3D4780
    """.trimIndent()

    private val inputPart2 = """
        04005AC33890
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day16(inputPart1).solvePart1()

            assertEquals(31, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day16(resourceAsText("day16.txt")).solvePart1()

            assertEquals(977, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day16(inputPart2).solvePart2()

            assertEquals(54, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day16(resourceAsText("day16.txt")).solvePart2()

            assertEquals(101_501_020_883, answer)
        }
    }
}