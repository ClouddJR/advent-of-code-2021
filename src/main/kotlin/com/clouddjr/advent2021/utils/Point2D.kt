package com.clouddjr.advent2021.utils

import kotlin.math.absoluteValue
import kotlin.math.sign

data class Point2D(val x: Int, val y: Int) {
    infix fun lineTo(other: Point2D): List<Point2D> {
        val dx = (other.x - x).sign
        val dy = (other.y - y).sign

        val steps = maxOf((x - other.x).absoluteValue, (y - other.y).absoluteValue)

        return (1..steps).scan(this) { last, _ -> Point2D(last.x + dx, last.y + dy) }
    }

    fun neighbours(): List<Point2D> {
        return arrayOf((-1 to 0), (1 to 0), (0 to -1), (0 to 1))
            .map { (dx, dy) -> Point2D(x + dx, y + dy) }
    }

    fun neighboursWithDiagonals(): List<Point2D> {
        return (-1..1).flatMap { dy -> (-1..1).map { dx -> dx to dy } }
            .filterNot { (dx, dy) -> dx == 0 && dy == 0 }
            .map { (dx, dy) -> Point2D(x + dx, y + dy) }
    }
}