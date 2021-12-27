package com.clouddjr.advent2021.utils

import kotlin.math.abs

data class Point3D(val x: Int, val y: Int, val z: Int) {
    operator fun plus(other: Point3D) = Point3D(x + other.x, y + other.y, z + other.z)

    operator fun minus(other: Point3D) = Point3D(x - other.x, y - other.y, z - other.z)

    infix fun distanceTo(other: Point3D) = abs(x - other.x) + abs(y - other.y) + abs(z - other.z)

    fun allRotations(): Set<Point3D> {
        return setOf(
            Point3D(x, y, z), Point3D(x, -z, y), Point3D(x, -y, -z), Point3D(x, z, -y), Point3D(-x, -y, z),
            Point3D(-x, -z, -y), Point3D(-x, y, -z), Point3D(-x, z, y), Point3D(-z, x, -y), Point3D(y, x, -z),
            Point3D(z, x, y), Point3D(-y, x, z), Point3D(z, -x, -y), Point3D(y, -x, z), Point3D(-z, -x, y),
            Point3D(-y, -x, -z), Point3D(-y, -z, x), Point3D(z, -y, x), Point3D(y, z, x), Point3D(-z, y, x),
            Point3D(z, y, -x), Point3D(-y, z, -x), Point3D(-z, -y, -x), Point3D(y, -z, -x),
        )
    }
}