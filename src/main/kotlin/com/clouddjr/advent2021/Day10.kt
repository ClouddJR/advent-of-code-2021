package com.clouddjr.advent2021

class Day10(private val input: List<String>) {

    private val matching = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')

    private val scoresIllegal = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)

    private val scoresCompletion = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)

    fun solvePart1(): Int {
        return input
            .sumOf { line ->
                with(ArrayDeque<Char>()) {
                    line.sumOf { c ->
                        when {
                            c in matching.keys -> (0).also { addLast(c) }
                            matching[removeLast()] != c -> scoresIllegal.getValue(c)
                            else -> 0
                        }
                    }
                }
            }
    }

    fun solvePart2(): Long {
        return input
            .map { line ->
                with(ArrayDeque<Char>()) {
                    line.forEach { c ->
                        when {
                            c in matching.keys -> addLast(c)
                            matching[removeLast()] != c -> return@map null
                        }
                    }
                    reversed()
                        .map { matching.getValue(it) }
                        .fold(0L) { acc, c -> (acc * 5 + scoresCompletion.getValue(c)) }
                }
            }
            .filterNotNull()
            .sorted()
            .let { it[it.size / 2] }
    }
}