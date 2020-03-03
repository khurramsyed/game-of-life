package com.test.gameoflife

class Universe(var size: Int) {
    var cells = Array(size) { Array(size) { Cell(false) } }

    fun startUniverse(vararg seed: Pair<Int, Int>) {
        seed.forEach {
                cells[it.first][it.second].isAlive = true
        }
    }
    
}