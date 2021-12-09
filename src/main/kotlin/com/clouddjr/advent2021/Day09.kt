package com.clouddjr.advent2021

class Day09(input: List<String>) {

    private val heightmap = input.map { row -> row.map { it.digitToInt() } }

    fun solvePart1(): Int {
        return lowPoints().sumOf { (x, y) -> heightmap[x][y] + 1 }
    }

    fun solvePart2(): Int {
        return lowPoints()
            .map { (rowIdx, colIdx) -> basin(rowIdx, colIdx).toSet().size }
            .sortedDescending()
            .take(3)
            .reduce { acc, i -> acc * i }
    }

    private fun basin(rowIdx: Int, colIdx: Int): List<Pair<Int, Int>> {
        return neighbours(rowIdx, colIdx)
            .filterNot { (x, y) -> heightmap[x][y] == 9 }
            .fold(listOf((rowIdx to colIdx))) { points, (x, y) ->
                points + if (heightmap[x][y] - heightmap[rowIdx][colIdx] >= 1) basin(x, y) else emptyList()
            }
    }

    private fun lowPoints(): List<Pair<Int, Int>> {
        return heightmap.foldIndexed(emptyList()) { rowIdx, allPoints, row ->
            row.foldIndexed(allPoints) { colIdx, points, height ->
                neighbours(rowIdx, colIdx)
                    .all { (x, y) -> heightmap[x][y] > height }
                    .let { isLowest -> if (isLowest) points + (rowIdx to colIdx) else points }
            }
        }
    }

    private fun neighbours(rowIdx: Int, colIdx: Int): List<Pair<Int, Int>> {
        return arrayOf((-1 to 0), (1 to 0), (0 to -1), (0 to 1))
            .map { (dx, dy) -> rowIdx + dx to colIdx + dy }
            .filter { (x, y) -> x in heightmap.indices && y in heightmap.first().indices }
    }
}