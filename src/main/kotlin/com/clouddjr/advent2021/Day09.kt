package com.clouddjr.advent2021

import com.clouddjr.advent2021.utils.Point2D

class Day09(input: List<String>) {

    private val heightmap = input.map { row -> row.map { it.digitToInt() } }

    fun solvePart1() = lowPoints().sumOf { heightmap[it] + 1 }

    fun solvePart2(): Int {
        return lowPoints()
            .map { basin(it).toSet().size }
            .sortedDescending()
            .take(3)
            .reduce { acc, i -> acc * i }
    }

    private fun basin(point: Point2D): List<Point2D> {
        return point.validNeighbours()
            .filterNot { heightmap[it] == 9 }
            .fold(listOf((point))) { points, neighbour ->
                points + if (heightmap[neighbour] > heightmap[point]) basin(neighbour) else emptyList()
            }
    }

    private fun lowPoints(): List<Point2D> {
        return heightmap.foldIndexed(emptyList()) { y, allPoints, row ->
            row.foldIndexed(allPoints) { x, points, height ->
                val current = Point2D(x, y)
                current.validNeighbours()
                    .all { heightmap[it] > height }
                    .let { isLowest -> if (isLowest) points + current else points }
            }
        }
    }

    private fun Point2D.validNeighbours(): List<Point2D> {
        return neighbours().filter { (x, y) -> y in heightmap.indices && x in heightmap.first().indices }
    }

    private operator fun List<List<Int>>.get(point: Point2D) = this[point.y][point.x]
}