package com.clouddjr.advent2021

class Day08(input: List<String>) {

    private val entries = input
        .map { it.split(" | ") }
        .map { (patterns, output) ->
            patterns.split(" ").map { it.toSet() } to output.split(" ").map { it.toSet() }
        }

    fun solvePart1(): Int {
        return entries.flatMap { it.second }.count { it.size in arrayOf(2, 3, 4, 7) }
    }

    fun solvePart2(): Int {
        return entries.sumOf { (patterns, output) ->
            val mappedDigits = mutableMapOf(
                1 to patterns.first { it.size == 2 },
                4 to patterns.first { it.size == 4 },
                7 to patterns.first { it.size == 3 },
                8 to patterns.first { it.size == 7 },
            )

            with(mappedDigits) {
                put(3, patterns.filter { it.size == 5 }.first { it.intersect(getValue(1)).size == 2 })
                put(2, patterns.filter { it.size == 5 }.first { it.intersect(getValue(4)).size == 2 })
                put(5, patterns.filter { it.size == 5 }.first { it !in values })
                put(6, patterns.filter { it.size == 6 }.first { it.intersect(getValue(1)).size == 1 })
                put(9, patterns.filter { it.size == 6 }.first { it.intersect(getValue(4)).size == 4 })
                put(0, patterns.filter { it.size == 6 }.first { it !in values })
            }

            val mappedPatterns = mappedDigits.entries.associateBy({ it.value }) { it.key }
            output.joinToString("") { mappedPatterns.getValue(it).toString() }.toInt()
        }
    }
}