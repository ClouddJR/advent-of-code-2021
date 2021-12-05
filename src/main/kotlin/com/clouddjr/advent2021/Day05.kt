package com.clouddjr.advent2021

import kotlin.math.abs

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

    fun solvePart1(): Int {
        return lines.filter { line -> line.x1 == line.x2 || line.y1 == line.y2 }
            .flatMap { it.points() }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }
    }

    fun solvePart2(): Int {
        return lines.flatMap { it.points() }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }
    }
}

data class Line(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {
    fun points() = horizontalRange().zip(verticalRange())

    private fun horizontalRange() = when {
        x2 > x1 -> (x1..x2)
        x1 > x2 -> (x1 downTo x2)
        else -> MutableList(abs(y2 - y1) + 1) { x1 }
    }.toList()

    private fun verticalRange() = when {
        y2 > y1 -> (y1..y2)
        y1 > y2 -> (y1 downTo y2)
        else -> MutableList(abs(x2 - x1) + 1) { y1 }
    }.toList()
}