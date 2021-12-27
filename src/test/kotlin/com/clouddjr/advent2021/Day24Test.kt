package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 24")
class Day24Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day24(resourceAsList("day24.txt")).solvePart1()

            assertEquals(92_967_699_949_891, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day24(resourceAsList("day24.txt")).solvePart2()

            assertEquals(91_411_143_612_181, answer)
        }
    }
}