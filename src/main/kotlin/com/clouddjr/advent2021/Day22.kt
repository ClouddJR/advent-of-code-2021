package com.clouddjr.advent2021

class Day22(input: List<String>) {

    private val cuboids = input.map { Cuboid.from(it) }

    fun solvePart1() = solve(cuboids.take(20))

    fun solvePart2() = solve(cuboids)

    private fun solve(cuboids: List<Cuboid>): Long {
        return cuboids.fold(listOf<Cuboid>()) { volumes, cuboid ->
            (volumes + volumes.mapNotNull { it intersect cuboid }).let { if (cuboid.on) it + cuboid else it }
        }.sumOf { it.volume() }
    }

    private class Cuboid(val on: Boolean, val x: IntRange, val y: IntRange, val z: IntRange) {
        fun volume(): Long = (x.size().toLong() * y.size().toLong() * z.size().toLong()) * if (on) 1 else -1

        infix fun intersect(other: Cuboid): Cuboid? {
            return when (x.intersects(other.x) && y.intersects(other.y) && z.intersects(other.z)) {
                true -> Cuboid(
                    !on,
                    maxOf(x.first, other.x.first)..minOf(x.last, other.x.last),
                    maxOf(y.first, other.y.first)..minOf(y.last, other.y.last),
                    maxOf(z.first, other.z.first)..minOf(z.last, other.z.last),
                )
                false -> null
            }
        }

        private fun IntRange.size() = last - first + 1

        private infix fun IntRange.intersects(other: IntRange): Boolean = first <= other.last && last >= other.first

        companion object {
            fun from(line: String): Cuboid {
                val pattern = """(on|off) x=(-?\d+)\.\.(-?\d+),y=(-?\d+)\.\.(-?\d+),z=(-?\d+)\.\.(-?\d+)""".toRegex()
                val (command, x1, x2, y1, y2, z1, z2) = pattern.matchEntire(line)!!.destructured
                return Cuboid(
                    command == "on",
                    (x1.toInt()..x2.toInt()),
                    (y1.toInt()..y2.toInt()),
                    (z1.toInt()..z2.toInt())
                )
            }
        }
    }
}