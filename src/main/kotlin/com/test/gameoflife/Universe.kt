package com.test.gameoflife


class Universe(var size: Int) {
    var cells = Array(size) { Array(size) { Cell(false) } }

    fun evolve() {
        cells = generateNextState()
    }

    private fun generateNextState() : Array<Array<Cell>>{
        var nextState = Array(size) { Array(size) { Cell(false) } }

        for (row in 0 until size) {
            for (column in 0 until size) {
                nextState[row][column].isAlive = evolveCell(row, column)
            }
        }
        return nextState
    }

    private fun evolveCell(row: Int, column: Int) =
        cells[row][column].nextMove(getLiveNeighbourCount(Pair(row, column)))


    fun startUniverse(vararg seed: Pair<Int, Int>) {
        seed.forEach {
            if (isInsideUniverse(it)) {
                cells[it.first][it.second].isAlive = true
            }
        }
    }

    private fun isInsideUniverse(coordinates: Pair<Int, Int>): Boolean {
        return (coordinates.first >= 0 && coordinates.first < cells.size) &&
                (coordinates.second >= 0 && coordinates.second < cells.size)
    }

    private fun getLiveNeighbourCount(cellLocation: Pair<Int, Int>): Int {
        val neighbors = listOf(
                Pair(cellLocation.first - 1, cellLocation.second - 1),
                Pair(cellLocation.first, cellLocation.second - 1),
                Pair(cellLocation.first + 1, cellLocation.second - 1),
                Pair(cellLocation.first - 1, cellLocation.second),
                Pair(cellLocation.first + 1, cellLocation.second),
                Pair(cellLocation.first - 1, cellLocation.second + 1),
                Pair(cellLocation.first, cellLocation.second + 1),
                Pair(cellLocation.first + 1, cellLocation.second + 1)
        ).filter { isInsideUniverse(it) && cells[it.first][it.second].isAlive }
        return neighbors.size

    }

    private fun drawBoard() {
        println("\u001b[H\u001b[2J")
        System.out.flush();
        for (row in 0 until size) {
            for (column in 0 until size) {
                print(if (cells[row][column].isAlive) "#" else ".")
                print(" ")
            }
            println()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val universe = Universe(25)
            universe.startUniverse(Pair(2, 2), Pair(3, 3), Pair(4, 1), Pair(4, 2), Pair(4, 3))

            for (i in 0 until 50) {
                universe.evolve()
                universe.drawBoard();
                Thread.sleep(300)
            }
        }
    }

}