package com.clouddjr.advent2021

import java.util.PriorityQueue

class Day15(input: List<String>) {

    private val riskLevels = input.map { row -> row.toCharArray().map { it.digitToInt() } }

    private val expandedRiskLevels = riskLevels.expand()

    fun solvePart1() = lowestRiskPath(riskLevels)

    fun solvePart2() = lowestRiskPath(expandedRiskLevels)

    private fun lowestRiskPath(levels: List<List<Int>>): Int {
        val dist = Array(levels.size) { Array(levels.first().size) { Int.MAX_VALUE } }.apply { get(0)[0] = 0 }

        val toVisit = PriorityQueue<Pair<Int, Int>> { (pY, pX), (rY, rX) -> dist[pY][pX].compareTo(dist[rY][rX]) }
        val visited = mutableSetOf(0 to 0)

        toVisit.add(0 to 0)
        while (toVisit.isNotEmpty()) {
            val (currentRow, currentCol) = toVisit.poll().also { visited.add(it) }
            neighbours(currentRow, currentCol, levels).forEach { (nextRow, nextCol) ->
                if (!visited.contains(nextRow to nextCol)) {
                    (dist[currentRow][currentCol] + levels[nextRow][nextCol]).let { newDistance ->
                        if (newDistance < dist[nextRow][nextCol]) {
                            dist[nextRow][nextCol] = newDistance
                            toVisit.offer(nextRow to nextCol)
                        }
                    }
                }
            }
        }

        return dist[dist.lastIndex][dist.last().lastIndex]
    }

    private fun List<List<Int>>.expand(): List<List<Int>> {
        val expandedRight = map { row -> (1 until 5).fold(row) { acc, step -> acc + row.increasedAndCapped(step) } }
        return (1 until 5).fold(expandedRight) { acc, step -> acc + expandedRight.increased(step) }
    }

    private fun List<List<Int>>.increased(by: Int) = map { row -> row.increasedAndCapped(by) }

    private fun List<Int>.increasedAndCapped(by: Int) = map { level -> (level + by).let { if (it > 9) it - 9 else it } }

    private fun neighbours(row: Int, col: Int, levels: List<List<Int>>): List<Pair<Int, Int>> {
        return arrayOf((-1 to 0), (1 to 0), (0 to -1), (0 to 1))
            .map { (dx, dy) -> row + dx to col + dy }
            .filter { (x, y) -> x in levels.indices && y in levels.first().indices }
    }
}