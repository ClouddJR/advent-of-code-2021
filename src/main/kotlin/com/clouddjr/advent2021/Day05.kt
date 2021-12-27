package com.clouddjr.advent2021

import com.clouddjr.advent2021.utils.Point2D

class Day05(input: List<String>) {

    private val lines = input
        .map { it.split(" -> ") }
        .map { (start, end) -> Pair(start.split(","), end.split(",")) }
        .map { (start, end) ->
            Line(
                Point2D(start.first().toInt(), start.last().toInt()),
                Point2D(end.first().toInt(), end.last().toInt()),
            )
        }

    fun solvePart1(): Int {
        return lines.filter { line -> line.start.x == line.end.x || line.start.y == line.end.y }
            .flatMap { it.start lineTo it.end }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }
    }

    fun solvePart2(): Int {
        return lines.flatMap { it.start lineTo it.end }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }
    }

    private data class Line(val start: Point2D, val end: Point2D)
}