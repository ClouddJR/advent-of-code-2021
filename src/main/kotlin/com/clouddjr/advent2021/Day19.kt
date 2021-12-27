package com.clouddjr.advent2021

import com.clouddjr.advent2021.utils.Point3D

class Day19(input: String) {

    private val scanners = input
        .split("""--- scanner \d+ ---""".toRegex())
        .filterNot { it.isEmpty() }
        .map { s ->
            Scanner(
                s.trim().lines()
                    .map { it.split(",") }
                    .map { (x, y, z) -> Point3D(x.toInt(), y.toInt(), z.toInt()) }
                    .toSet()
            )
        }

    fun solvePart1() = assembleMap().beacons.size

    fun solvePart2(): Int {
        return assembleMap().scannersPositions.let { positions ->
            positions.flatMapIndexed { index, first -> positions.drop(index + 1).map { second -> first to second } }
                .maxOf { (first, second) -> first distanceTo second }
        }
    }

    private fun assembleMap(): AssembledMap {
        val foundBeacons = scanners.first().beacons.toMutableSet()
        val foundScannersPositions = mutableSetOf(Point3D(0, 0, 0))

        val remaining = ArrayDeque<Scanner>().apply { addAll(scanners.drop(1)) }
        while (remaining.isNotEmpty()) {
            val candidate = remaining.removeFirst()
            when (val transformedCandidate = Scanner(foundBeacons).getTransformedIfOverlap(candidate)) {
                null -> remaining.add(candidate)
                else -> {
                    foundBeacons.addAll(transformedCandidate.beacons)
                    foundScannersPositions.add(transformedCandidate.position)
                }
            }
        }

        return AssembledMap(foundBeacons, foundScannersPositions)
    }

    private data class Scanner(val beacons: Set<Point3D>) {
        fun allRotations() = beacons.map { it.allRotations() }.transpose().map { Scanner(it) }

        fun getTransformedIfOverlap(otherScanner: Scanner): TransformedScanner? {
            return otherScanner.allRotations().firstNotNullOfOrNull { otherReoriented ->
                beacons.firstNotNullOfOrNull { first ->
                    otherReoriented.beacons.firstNotNullOfOrNull { second ->
                        val otherPosition = first - second
                        val otherTransformed = otherReoriented.beacons.map { otherPosition + it }.toSet()
                        when ((otherTransformed intersect beacons).size >= 12) {
                            true -> TransformedScanner(otherTransformed, otherPosition)
                            false -> null
                        }
                    }
                }
            }
        }

        private fun List<Set<Point3D>>.transpose(): List<Set<Point3D>> {
            return when (all { it.isNotEmpty() }) {
                true -> listOf(map { it.first() }.toSet()) + map { it.drop(1).toSet() }.transpose()
                false -> emptyList()
            }
        }
    }

    private data class TransformedScanner(val beacons: Set<Point3D>, val position: Point3D)

    private data class AssembledMap(val beacons: Set<Point3D>, val scannersPositions: Set<Point3D>)
}