package com.clouddjr.advent2021

class Day13(input: List<String>) {

    private val points = input
        .takeWhile { it.isNotEmpty() }
        .map { it.substringBefore(",").toInt() to it.substringAfter(",").toInt() }
        .toSet()

    private val folds = input
        .takeLastWhile { it.isNotEmpty() }
        .map { it.substringAfterLast(" ") }
        .map { it.substringBefore("=") to it.substringAfter("=").toInt() }

    fun solvePart1(): Int {
        return foldPaper(folds.take(1)).count()
    }

    fun solvePart2(): Set<Pair<Int, Int>> {
        return foldPaper(folds) // CPJBERUL
    }

    private fun foldPaper(folds: List<Pair<String, Int>>): Set<Pair<Int, Int>> {
        return folds.fold(points) { points, instruction ->
            val (axis, position) = instruction
            when (axis) {
                "y" -> points
                    .filter { it.second > position }
                    .map { it.first to 2 * position - it.second }
                    .toSet() + points.filter { it.second < position }
                else -> points
                    .filter { it.first > position }
                    .map { 2 * position - it.first to it.second }
                    .toSet() + points.filter { it.first < position }
            }
        }
    }
}