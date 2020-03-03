package com.test.gameoflife

class Universe(var size: Int) {
    var cells = Array(size) { Array(size) { Cell(false) } }

    fun startUniverse(vararg seed: Pair<Int, Int>) {
        seed.forEach {
            if (isValidIndex(it)) {
                cells[it.first][it.second].isAlive = true
            }
        }
    }

    private fun isValidIndex(coordinates: Pair<Int, Int>): Boolean {
        return (coordinates.first >= 0 && coordinates.first < cells.size) &&
                (coordinates.second >= 0 && coordinates.second < cells.size)
    }


}