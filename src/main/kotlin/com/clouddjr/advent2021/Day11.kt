package com.clouddjr.advent2021

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
}

class Octopuses(private val energies: Array<Array<Int>>) {

    fun increaseEnergy() {
        energies.forEachIndexed { y, row ->
            row.forEachIndexed { x, _ ->
                energies[y][x]++
            }
        }
    }

    fun flash(): Int {
        val visited = mutableSetOf<Pair<Int, Int>>()
        energies.forEachIndexed { y, row ->
            row.forEachIndexed { x, energy ->
                if (energy > 9 && (y to x) !in visited) {
                    val toVisit = ArrayDeque(listOf(y to x))
                    visited.add(y to x)
                    while (toVisit.isNotEmpty()) {
                        val (nextY, nextX) = toVisit.removeLast()
                        neighbours(nextY, nextX)
                            .filter { it !in visited }
                            .filter { (y, x) -> ++energies[y][x] > 9 }
                            .forEach { (y, x) ->
                                toVisit.addLast(y to x)
                                visited.add(y to x)
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

    private fun neighbours(y: Int, x: Int): List<Pair<Int, Int>> {
        return (-1..1).flatMap { dy -> (-1..1).map { dx -> dy to dx } }
            .filterNot { (dy, dx) -> dy == 0 && dx == 0 }
            .map { (dy, dx) -> y + dy to x + dx }
            .filter { (y, x) -> y in energies.indices && x in energies.first().indices }
    }
}