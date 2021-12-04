package com.clouddjr.advent2021

class Day04(input: String) {
    private val numbers: List<Int>
    private val boards: List<Board>

    init {
        val split = input.split("\n\n")
        numbers = split[0].split(",").map { it.toInt() }
        boards = split.drop(1).map { Board(it) }
    }

    fun solvePart1(): Int {
        numbers.forEach { number ->
            boards.onEach { board -> board.mark(number) }
                .firstOrNull { it.hasWon() }
                ?.let { winningBoard ->
                    return number * winningBoard.sumOfUnmarked()
                }
        }
        throw Exception()
    }

    fun solvePart2(): Int {
        numbers.fold(boards) { boards, number ->
            if (boards.size == 1) {
                boards.first().apply { mark(number) }.takeIf { it.hasWon() }?.let {
                    return number * it.sumOfUnmarked()
                }
            }
            boards.onEach { board -> board.mark(number) }.filterNot { it.hasWon() }
        }
        throw Exception()
    }
}

class Board(boardRepresentation: String) {

    private val numbers = Array(5) { Array(5) { Number(0) } }

    init {
        boardRepresentation.split("\n").forEachIndexed { rowIndex, row ->
            row.split(" ").filterNot { it.isBlank() }.forEachIndexed { colIndex, number ->
                numbers[rowIndex][colIndex] = Number(number.toInt())
            }
        }
    }

    fun mark(value: Int) {
        numbers.forEach { row ->
            row.filter { number -> number.value == value }
                .onEach { number -> number.marked = true }
        }
    }

    fun hasWon(): Boolean {
        val hasWinningRow = numbers.any { row ->
            row.all { it.marked }
        }

        val hasWinningCol = (0 until 5).any { col ->
            numbers.map { row -> row[col] }.all { number -> number.marked }
        }

        return hasWinningRow || hasWinningCol
    }

    fun sumOfUnmarked(): Int {
        return numbers.sumOf { row ->
            row.filterNot { number -> number.marked }.sumOf { number -> number.value }
        }
    }
}

data class Number(val value: Int, var marked: Boolean = false)