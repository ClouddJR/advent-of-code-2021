package com.clouddjr.advent2021

import com.clouddjr.advent2021.utils.Point2D

class Day13(input: List<String>) {

    private val points = input
        .takeWhile { it.isNotEmpty() }
        .map { Point2D(it.substringBefore(",").toInt(), it.substringAfter(",").toInt()) }
        .toSet()

    private val folds = input
        .takeLastWhile { it.isNotEmpty() }
        .map { it.substringAfterLast(" ") }
        .map { it.substringBefore("=") to it.substringAfter("=").toInt() }

    fun solvePart1() = foldPaper(folds.take(1)).count()

    fun solvePart2() = foldPaper(folds) // CPJBERUL

    private fun foldPaper(folds: List<Pair<String, Int>>): Set<Point2D> {
        return folds.fold(points) { points, instruction ->
            val (axis, position) = instruction
            when (axis) {
                "y" -> points
                    .filter { it.y > position }
                    .map { Point2D(it.x, 2 * position - it.y) }
                    .toSet() + points.filter { it.y < position }
                else -> points
                    .filter { it.x > position }
                    .map { Point2D(2 * position - it.x, it.y) }
                    .toSet() + points.filter { it.x < position }
            }
        }
    }
}