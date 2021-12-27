package com.clouddjr.advent2021

class Day21(input: List<String>) {

    private val p1StartingPosition = input.first().last().digitToInt() - 1

    private val p2StartingPosition = input.last().last().digitToInt() - 1

    private val initialGameState = GameState(PlayerState(p1StartingPosition, 0), PlayerState(p2StartingPosition, 0))

    private val diceOutcomes = (1..3).flatMap { x -> (1..3).flatMap { y -> (1..3).map { z -> x + y + z } } }
        .groupingBy { it }
        .eachCount()
        .mapValues { it.value.toLong() }

    private val cache = mutableMapOf<GameState, WonCount>()

    fun solvePart1() = playWithDeterministicDice()

    fun solvePart2() = playWithDiracDice().maxScore()

    private fun playWithDeterministicDice(gameState: GameState = initialGameState, turn: Int = 0): Int {
        return when {
            gameState.hasAWinner() -> gameState.minScore() * turn * 3
            else -> playWithDeterministicDice(gameState.next(deterministicDiceRollsSum(turn)), turn + 1)
        }
    }

    private fun playWithDiracDice(gameState: GameState = initialGameState): WonCount {
        return when {
            gameState.p1State.score >= 21 -> WonCount(1, 0)
            gameState.p2State.score >= 21 -> WonCount(0, 1)
            else -> cache.getOrPut(gameState) {
                diceOutcomes.map { (forward, freq) -> playWithDiracDice(gameState.next(forward)) * freq }
                    .reduce { acc, count -> acc + count }
            }
        }
    }

    private fun deterministicDiceRollsSum(turn: Int) = (turn * 3) + (turn * 3 + 1) + (turn * 3 + 2) + 3

    private data class GameState(val p1State: PlayerState, val p2State: PlayerState, val p1Turn: Boolean = true) {
        fun next(rollSum: Int): GameState {
            return GameState(
                if (p1Turn) p1State.next(rollSum) else p1State,
                if (!p1Turn) p2State.next(rollSum) else p2State,
                !p1Turn
            )
        }

        fun hasAWinner(neededScore: Int = 1000) = p1State.score >= neededScore || p2State.score >= neededScore

        fun minScore() = minOf(p1State.score, p2State.score)
    }

    private data class PlayerState(val position: Int, val score: Int) {
        fun next(rollSum: Int): PlayerState {
            val p1NewPosition = (position + rollSum) % 10
            return PlayerState(p1NewPosition, score + p1NewPosition + 1)
        }
    }

    private class WonCount(val p1: Long, val p2: Long) {
        operator fun plus(other: WonCount) = WonCount(p1 + other.p1, p2 + other.p2)

        operator fun times(other: Long) = WonCount(p1 * other, p2 * other)

        fun maxScore() = maxOf(p1, p2)
    }
}