package com.clouddjr.advent2021

class Day02(input: List<String>) {

    private val commands = input.map { it.split(" ") }

    fun solvePart1(): Int {
        var horizontal = 0
        var depth = 0

        commands.forEach { (command, value) ->
            when (command) {
                "forward" -> horizontal += value.toInt()
                "down" -> depth += value.toInt()
                "up" -> depth -= value.toInt()
            }
        }

        return horizontal * depth
    }

    fun solvePart2(): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        commands.forEach { (command, value) ->
            when (command) {
                "forward" -> {
                    horizontal += value.toInt()
                    depth += aim * value.toInt()
                }
                "down" -> aim += value.toInt()
                "up" -> aim -= value.toInt()
            }
        }

        return horizontal * depth
    }
}