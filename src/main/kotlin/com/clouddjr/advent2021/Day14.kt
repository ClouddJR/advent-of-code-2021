package com.clouddjr.advent2021

class Day14(input: List<String>) {

    private val template = input.first()

    private val rules = input
        .takeLastWhile { it.isNotEmpty() }
        .groupBy({ it.substringBefore(" -> ") }, { it.substringAfter(" -> ") })
        .mapValues { it.value.single() }

    fun solvePart1(): Long {
        return insertionProcess(10)
    }

    fun solvePart2(): Long {
        return insertionProcess(40)
    }

    private fun insertionProcess(steps: Int): Long {
        val initial = template.windowed(2).groupingBy { it }.eachCount().mapValues { it.value.toLong() }

        val pairsCount = (0 until steps).fold(initial) { current, _ ->
            buildMap {
                current.forEach { (pair, count) ->
                    val first = pair[0] + rules.getValue(pair)
                    val second = rules.getValue(pair) + pair[1]
                    put(first, getOrDefault(first, 0) + count)
                    put(second, getOrDefault(second, 0) + count)
                }
            }
        }

        val charsCount = buildMap<Char, Long> {
            put(template[0], 1)
            pairsCount.forEach { (pair, count) ->
                put(pair[1], getOrDefault(pair[1], 0) + count)
            }
        }

        return charsCount.maxOf { it.value } - charsCount.minOf { it.value }
    }
}