package com.test.gameoflife

class Cell(var isAlive: Boolean) {

    fun nextMove(livingNeighbourCount: Int):Cell{
        return when(livingNeighbourCount){
            0,1 -> Cell(false)
            2 -> Cell(isAlive)
            3 -> Cell(true)
            else -> Cell(false)
        }
    }
}