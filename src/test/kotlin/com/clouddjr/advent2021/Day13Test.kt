package com.clouddjr.advent2021

import com.clouddjr.advent2021.Resources.resourceAsList
import com.clouddjr.advent2021.utils.Point2D
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
                    Point2D(2, 0),
                    Point2D(12, 0),
                    Point2D(8, 2),
                    Point2D(8, 1),
                    Point2D(23, 5),
                    Point2D(1, 0),
                    Point2D(6, 0),
                    Point2D(32, 5),
                    Point2D(30, 3),
                    Point2D(16, 2),
                    Point2D(27, 0),
                    Point2D(1, 5),
                    Point2D(26, 0),
                    Point2D(25, 4),
                    Point2D(25, 1),
                    Point2D(13, 4),
                    Point2D(33, 1),
                    Point2D(22, 0),
                    Point2D(35, 4),
                    Point2D(18, 1),
                    Point2D(15, 2),
                    Point2D(5, 1),
                    Point2D(21, 5),
                    Point2D(20, 5),
                    Point2D(15, 1),
                    Point2D(38, 5),
                    Point2D(35, 5),
                    Point2D(37, 5),
                    Point2D(28, 2),
                    Point2D(3, 4),
                    Point2D(13, 1),
                    Point2D(28, 5),
                    Point2D(25, 5),
                    Point2D(5, 4),
                    Point2D(36, 5),
                    Point2D(23, 0),
                    Point2D(22, 5),
                    Point2D(20, 1),
                    Point2D(35, 2),
                    Point2D(0, 4),
                    Point2D(33, 2),
                    Point2D(21, 0),
                    Point2D(7, 3),
                    Point2D(20, 0),
                    Point2D(15, 4),
                    Point2D(30, 2),
                    Point2D(25, 3),
                    Point2D(15, 5),
                    Point2D(27, 3),
                    Point2D(33, 0),
                    Point2D(18, 4),
                    Point2D(27, 4),
                    Point2D(20, 4),
                    Point2D(10, 4),
                    Point2D(5, 5),
                    Point2D(11, 5),
                    Point2D(31, 5),
                    Point2D(35, 0),
                    Point2D(21, 2),
                    Point2D(30, 0),
                    Point2D(30, 4),
                    Point2D(17, 0),
                    Point2D(18, 3),
                    Point2D(17, 5),
                    Point2D(5, 0),
                    Point2D(26, 3),
                    Point2D(5, 2),
                    Point2D(0, 3),
                    Point2D(2, 5),
                    Point2D(30, 1),
                    Point2D(7, 0),
                    Point2D(15, 0),
                    Point2D(13, 0),
                    Point2D(22, 2),
                    Point2D(17, 2),
                    Point2D(35, 3),
                    Point2D(20, 3),
                    Point2D(25, 2),
                    Point2D(28, 1),
                    Point2D(13, 2),
                    Point2D(33, 3),
                    Point2D(15, 3),
                    Point2D(12, 5),
                    Point2D(6, 3),
                    Point2D(0, 2),
                    Point2D(25, 0),
                    Point2D(5, 3),
                    Point2D(35, 1),
                    Point2D(3, 1),
                    Point2D(16, 5),
                    Point2D(33, 4),
                    Point2D(0, 1),
                    Point2D(16, 0),
                    Point2D(13, 3),
                    Point2D(20, 2),
                ), answer
            )
        }
    }
}