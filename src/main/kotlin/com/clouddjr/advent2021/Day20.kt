package com.clouddjr.advent2021

class Day20(input: List<String>) {

    private val replaced = input.map { row -> row.map { if (it == '#') '1' else '0' }.joinToString("") }
    private val algorithm = replaced.first().toCharArray()
    private val startingImage = replaced.drop(2)

    fun solvePart1() = enhance(2)

    fun solvePart2() = enhance(50)

    private fun enhance(steps: Int): Int {
        val resultingImage = (0 until steps).fold(startingImage) { image, step ->
            val outside = when (algorithm.first() == '1') {
                true -> if (step % 2 == 0) algorithm.last() else algorithm.first()
                false -> '0'
            }
            (-1..image.size).map { y ->
                (-1..image.first().length).map { x ->
                    (-1..1).flatMap { dy -> (-1..1).map { dx -> dy to dx } }
                        .map { (dy, dx) -> y + dy to x + dx }
                        .joinToString("") { (y, x) -> (image.getOrNull(y)?.getOrNull(x) ?: outside).toString() }
                        .toInt(2).let { algorithm[it] }
                }.joinToString("")
            }
        }
        return resultingImage.sumOf { row -> row.count { it == '1' } }
    }
}