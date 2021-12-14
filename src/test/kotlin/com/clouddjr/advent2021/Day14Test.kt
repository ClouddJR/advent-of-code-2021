package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 14")
class Day14Test {

    private val input = """
        NNCB

        CH -> B
        HH -> N
        CB -> H
        NH -> C
        HB -> C
        HC -> B
        HN -> C
        NN -> C
        BH -> H
        NC -> B
        NB -> B
        BN -> B
        BB -> N
        BC -> B
        CC -> N
        CN -> C
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day14(input).solvePart1()

            assertEquals(1588, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day14(resourceAsList("day14.txt")).solvePart1()

            assertEquals(2891, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day14(input).solvePart2()

            assertEquals(2_188_189_693_529, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day14(resourceAsList("day14.txt")).solvePart2()

            assertEquals(4_607_749_009_683, answer)
        }
    }
}