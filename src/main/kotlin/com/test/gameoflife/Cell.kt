package com.test.gameoflife

class Cell(var isAlive: Boolean) {

    fun nextMove(livingNeighbourCount: Int): Boolean{
        return when (livingNeighbourCount) {
            0, 1 -> false
            2 -> isAlive
            3 -> true
            else -> false
        }
    }
}