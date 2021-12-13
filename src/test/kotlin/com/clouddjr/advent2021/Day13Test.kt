package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 13")
class Day13Test {

    private val input = """
        6,10
        0,14
        9,10
        0,3
        10,4
        4,11
        6,0
        6,12
        4,1
        0,13
        10,12
        3,4
        3,0
        8,4
        1,10
        2,14
        8,10
        9,0

        fold along y=7
        fold along x=5
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day13(input).solvePart1()

            assertEquals(17, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day13(resourceAsList("day13.txt")).solvePart1()

            assertEquals(724, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day13(resourceAsList("day13.txt")).solvePart2()

            assertEquals(
                setOf(
                    2 to 0,
                    12 to 0,
                    8 to 2,
                    8 to 1,
                    23 to 5,
                    1 to 0,
                    6 to 0,
                    32 to 5,
                    30 to 3,
                    16 to 2,
                    27 to 0,
                    1 to 5,
                    26 to 0,
                    25 to 4,
                    25 to 1,
                    13 to 4,
                    33 to 1,
                    22 to 0,
                    35 to 4,
                    18 to 1,
                    15 to 2,
                    5 to 1,
                    21 to 5,
                    20 to 5,
                    15 to 1,
                    38 to 5,
                    35 to 5,
                    37 to 5,
                    28 to 2,
                    3 to 4,
                    13 to 1,
                    28 to 5,
                    25 to 5,
                    5 to 4,
                    36 to 5,
                    23 to 0,
                    22 to 5,
                    20 to 1,
                    35 to 2,
                    0 to 4,
                    33 to 2,
                    21 to 0,
                    7 to 3,
                    20 to 0,
                    15 to 4,
                    30 to 2,
                    25 to 3,
                    15 to 5,
                    27 to 3,
                    33 to 0,
                    18 to 4,
                    27 to 4,
                    20 to 4,
                    10 to 4,
                    5 to 5,
                    11 to 5,
                    31 to 5,
                    35 to 0,
                    21 to 2,
                    30 to 0,
                    30 to 4,
                    17 to 0,
                    18 to 3,
                    17 to 5,
                    5 to 0,
                    26 to 3,
                    5 to 2,
                    0 to 3,
                    2 to 5,
                    30 to 1,
                    7 to 0,
                    15 to 0,
                    13 to 0,
                    22 to 2,
                    17 to 2,
                    35 to 3,
                    20 to 3,
                    25 to 2,
                    28 to 1,
                    13 to 2,
                    33 to 3,
                    15 to 3,
                    12 to 5,
                    6 to 3,
                    0 to 2,
                    25 to 0,
                    5 to 3,
                    35 to 1,
                    3 to 1,
                    16 to 5,
                    33 to 4,
                    0 to 1,
                    16 to 0,
                    13 to 3,
                    20 to 2
                ), answer
            )
        }
    }
}