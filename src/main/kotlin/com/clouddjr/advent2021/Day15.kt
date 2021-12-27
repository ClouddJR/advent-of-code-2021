package com.clouddjr.advent2021

import com.clouddjr.advent2021.utils.Point2D
import java.util.PriorityQueue

class Day15(input: List<String>) {

    private val riskLevels = input.map { row -> row.toCharArray().map { it.digitToInt() } }

    private val expandedRiskLevels = riskLevels.expand()

    fun solvePart1() = lowestRiskPath(riskLevels)

    fun solvePart2() = lowestRiskPath(expandedRiskLevels)

    private fun lowestRiskPath(riskLevels: List<List<Int>>): Int {
        val dist = Array(riskLevels.size) { Array(riskLevels.first().size) { Int.MAX_VALUE } }.apply { this[0][0] = 0 }
        val toVisit = PriorityQueue<Point2D> { p1, p2 -> dist[p1.y][p1.x].compareTo(dist[p2.y][p2.x]) }
        val visited = mutableSetOf<Point2D>()
        toVisit.add(Point2D(0, 0))

        while (toVisit.isNotEmpty()) {
            val current = toVisit.poll().also { visited.add(it) }
            current.validNeighbours(riskLevels).forEach { neighbour ->
                if (!visited.contains(neighbour)) {
                    val newDistance = dist[current] + riskLevels[neighbour]
                    if (newDistance < dist[neighbour]) {
                        dist[neighbour] = newDistance
                        toVisit.add(neighbour)
                    }
                }
            }
        }

        return dist[dist.lastIndex][dist.last().lastIndex]
    }

    private operator fun Array<Array<Int>>.get(point: Point2D) = this[point.y][point.x]

    private operator fun Array<Array<Int>>.set(point: Point2D, value: Int) {
        this[point.y][point.x] = value
    }

    private operator fun List<List<Int>>.get(point: Point2D) = this[point.y][point.x]

    private fun List<List<Int>>.expand(): List<List<Int>> {
        val expandedRight = map { row -> (1 until 5).fold(row) { acc, step -> acc + row.increasedAndCapped(step) } }
        return (1 until 5).fold(expandedRight) { acc, step -> acc + expandedRight.increased(step) }
    }

    private fun List<List<Int>>.increased(by: Int) = map { row -> row.increasedAndCapped(by) }

    private fun List<Int>.increasedAndCapped(by: Int) = map { level -> (level + by).let { if (it > 9) it - 9 else it } }

    private fun Point2D.validNeighbours(riskLevels: List<List<Int>>): List<Point2D> {
        return neighbours().filter { (x, y) -> y in riskLevels.indices && x in riskLevels.first().indices }
    }
}