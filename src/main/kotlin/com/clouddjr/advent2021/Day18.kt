package com.clouddjr.advent2021

class Day18(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.reduce { acc, s -> Node.of("[$acc,$s]").apply { reduce() }.toString() }
            .let { Node.of(it).magnitude() }
    }

    fun solvePart2(): Int {
        return input.maxOf { first ->
            input.filterNot { it == first }.maxOf { second ->
                Node.of("[$first,$second]").apply { reduce() }.magnitude()
            }
        }
    }

    private sealed class Node {
        abstract fun magnitude(): Int
        abstract fun addToLeftMost(value: Int)
        abstract fun addToRightMost(value: Int)
        abstract fun split(): Boolean
        abstract fun explode(depth: Int = 0): Pair<Int, Int>?

        fun reduce() {
            do {
                val exploded = explode() != null
                val split = if (!exploded) split() else false
            } while (exploded || split)
        }

        companion object {
            fun of(line: String): Node {
                return when (line.length == 1) {
                    true -> NodeNumber.of(line)
                    false -> NodePair.of(line)
                }
            }
        }
    }

    private class NodeNumber(var value: Int) : Node() {
        override fun magnitude() = value

        override fun addToLeftMost(value: Int) = run { this.value += value }

        override fun addToRightMost(value: Int) = run { this.value += value }

        override fun split() = false

        override fun explode(depth: Int): Pair<Int, Int>? = null

        override fun toString() = "$value"

        companion object {
            fun of(line: String) = NodeNumber(line.toInt())
        }
    }

    private class NodePair(var left: Node, var right: Node) : Node() {
        override fun magnitude() = 3 * left.magnitude() + 2 * right.magnitude()

        override fun addToLeftMost(value: Int) = left.addToLeftMost(value)

        override fun addToRightMost(value: Int) = right.addToRightMost(value)

        override fun split(): Boolean {
            if (left is NodeNumber) {
                (left as NodeNumber).value.let {
                    if (it >= 10) {
                        left = NodePair(NodeNumber(it / 2), NodeNumber((it + 1) / 2))
                        return true
                    }
                }
            }
            if (left.split()) {
                return true
            }
            if (right is NodeNumber) {
                (right as NodeNumber).value.let {
                    if (it >= 10) {
                        right = NodePair(NodeNumber(it / 2), NodeNumber((it + 1) / 2))
                        return true
                    }
                }
            }
            return right.split()
        }

        override fun explode(depth: Int): Pair<Int, Int>? {
            if (depth == 4) {
                return (left as NodeNumber).value to (right as NodeNumber).value
            }
            left.explode(depth + 1)?.let { (first, second) ->
                if (first != -1 && second != -1) {
                    this.left = NodeNumber(0)
                    this.right.addToLeftMost(second)
                    return first to -1
                }
                if (second != -1) {
                    this.right.addToLeftMost(second)
                    return -1 to -1
                }
                return first to -1
            }
            right.explode(depth + 1)?.let { (first, second) ->
                if (first != -1 && second != -1) {
                    this.right = NodeNumber(0)
                    this.left.addToRightMost(first)
                    return -1 to second
                }
                if (first != -1) {
                    this.left.addToRightMost(first)
                    return -1 to -1
                }
                return -1 to second
            }
            return null
        }

        override fun toString() = "[$left,$right]"

        companion object {
            fun of(line: String): Node {
                val inside = line.drop(1).dropLast(1)
                var left = ""
                var brackets = 0
                for (c in inside) {
                    if (c == '[') brackets++
                    if (c == ']') brackets--
                    if (c == ',' && brackets == 0) break
                    left += c
                }
                val right = inside.drop(left.length + 1)
                return NodePair(Node.of(left), Node.of(right))
            }
        }
    }
}