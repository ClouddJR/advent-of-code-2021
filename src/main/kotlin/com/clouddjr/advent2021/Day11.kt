package com.clouddjr.advent2021

import com.clouddjr.advent2021.utils.Point2D

class Day11(input: List<String>) {

    private val octopuses = input
        .map { row -> row.toCharArray().map { it.digitToInt() }.toTypedArray() }
        .toTypedArray()
        .let { Octopuses(it) }

    fun solvePart1(): Int {
        return sequenceOfFlashes()
            .take(100)
            .sum()
    }

    fun solvePart2(): Int {
        return sequenceOfFlashes()
            .takeWhile { octopuses.areNotSynchronized() }
            .count() + 1
    }

    private fun sequenceOfFlashes() = generateSequence {
        octopuses.increaseEnergy()
        octopuses.flash().also { octopuses.resetFlashed() }
    }

    private class Octopuses(private val energies: Array<Array<Int>>) {
        fun increaseEnergy() {
            energies.forEachIndexed { y, row ->
                row.forEachIndexed { x, _ ->
                    energies[y][x]++
                }
            }
        }

        fun flash(): Int {
            val visited = mutableSetOf<Point2D>()
            energies.forEachIndexed { y, row ->
                row.forEachIndexed { x, energy ->
                    val current = Point2D(x, y)
                    if (energy > 9 && current !in visited) {
                        val toVisit = ArrayDeque<Point2D>().apply { addLast(current) }
                        visited.add(current)
                        while (toVisit.isNotEmpty()) {
                            val next = toVisit.removeLast()
                            next.validNeighbours()
                                .filter { it !in visited }
                                .filter { (x, y) -> ++energies[y][x] > 9 }
                                .forEach {
                                    toVisit.addLast(it)
                                    visited.add(it)
                                }
                        }
                    }
                }
            }
            return visited.size
        }

        fun resetFlashed() {
            energies.forEachIndexed { y, row ->
                row.forEachIndexed { x, _ ->
                    energies[y][x] = if (energies[y][x] > 9) 0 else energies[y][x]
                }
            }
        }

        fun areNotSynchronized() = energies.any { row -> row.any { energy -> energy > 0 } }

        private fun Point2D.validNeighbours(): List<Point2D> {
            return neighboursWithDiagonals().filter { (y, x) -> y in energies.indices && x in energies.first().indices }
        }
    }
}