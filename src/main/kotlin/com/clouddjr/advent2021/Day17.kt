package com.clouddjr.advent2021

class Day17(input: String) {

    private val targetArea = Regex("""target area: x=(\d+)\.\.(\d+), y=(-\d+)\.\.(-\d+)""")
        .matchEntire(input)!!
        .destructured.let { (x1, x2, y1, y2) -> TargetArea(x1.toInt(), x2.toInt(), y1.toInt(), y2.toInt()) }

    fun solvePart1() = (-targetArea.y1 - 1).sequenceSum()

    fun solvePart2(): Int {
        val minY = targetArea.y1
        val maxY = -targetArea.y1 - 1
        val minX = (1..targetArea.x1).first { it.sequenceSum() >= targetArea.x1 }
        val maxX = targetArea.x2

        return (minX..maxX).sumOf { x ->
            (minY..maxY).count { y ->
                Velocity(x, y).willBeWithin(targetArea)
            }
        }
    }

    data class TargetArea(val x1: Int, val x2: Int, val y1: Int, val y2: Int) {
        operator fun contains(point: Pair<Int, Int>) = point.first in x1..x2 && point.second in y1..y2
    }

    data class Velocity(val x: Int, val y: Int) {
        fun willBeWithin(target: TargetArea): Boolean {
            val seqX = seqX().takeWhile { (posX, _) -> posX <= target.x2 }.map { it.first }
            val seqY = seqY().takeWhile { (posY, _) -> posY >= target.y1 }.map { it.first }

            return (seqX zip seqY).any { it in target }
        }

        private fun seqX() = generateSequence(0 to x) { (posX, velX) -> posX + velX to maxOf(0, velX - 1) }

        private fun seqY() = generateSequence(0 to y) { (posY, velY) -> posY + velY to velY - 1 }
    }

    private fun Int.sequenceSum(): Int {
        return (1 + this) * this / 2
    }
}