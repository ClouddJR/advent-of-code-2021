package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 23")
class Day23Test {

    private val input = """
        #############
        #...........#
        ###B#C#B#D###
          #A#D#C#A#
          #########
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day23(input).solvePart1()

            assertEquals(12521, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day23(resourceAsList("day23.txt")).solvePart1()

            assertEquals(15472, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day23(input).solvePart2()

            assertEquals(44169, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day23(resourceAsList("day23.txt")).solvePart2()

            assertEquals(46182, answer)
        }
    }
}