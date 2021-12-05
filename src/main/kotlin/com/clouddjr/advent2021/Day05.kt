package com.clouddjr.advent2021

import kotlin.math.abs
import kotlin.math.max

class Day05(input: List<String>) {
    private val lines = input
        .map { it.split(" -> ") }
        .map { (start, end) -> Pair(start.split(","), end.split(",")) }
        .map { (start, end) ->
            Line(
                start.first().toInt(),
                start.last().toInt(),
                end.first().toInt(),
                end.last().toInt()
            )
        }

    private val maxX = lines.maxOf { line -> max(line.x1, line.x2) }
    private val maxY = lines.maxOf { line -> max(line.y1, line.y2) }

    private val diagram = Array(maxY + 1) { Array(maxX + 1) { 0 } }

    fun solvePart1(): Int {
        lines.filter { line -> line.x1 == line.x2 || line.y1 == line.y2 }
            .forEach { line ->
                line.horizontalRange().zip(line.verticalRange()).forEach { (x, y) -> diagram[y][x]++ }
            }

        return diagram.sumOf { row -> row.count { overlaps -> overlaps >= 2 } }
    }

    fun solvePart2(): Int {
        lines.forEach { line ->
            line.verticalRange().zip(line.horizontalRange()).forEach { (y, x) -> diagram[y][x]++ }
        }

        return diagram.sumOf { row -> row.count { overlaps -> overlaps >= 2 } }
    }
}

data class Line(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {
    fun horizontalRange() = when {
        x2 > x1 -> (x1..x2)
        x1 > x2 -> (x1 downTo x2)
        else -> MutableList(abs(y2 - y1) + 1) { x1 }
    }.toList()

    fun verticalRange() = when {
        y2 > y1 -> (y1..y2)
        y1 > y2 -> (y1 downTo y2)
        else -> MutableList(abs(x2 - x1) + 1) { y1 }
    }.toList()
}