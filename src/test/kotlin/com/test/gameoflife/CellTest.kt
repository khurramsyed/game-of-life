package com.test.gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CellTest {
    @Test
    fun aLivingCellWithNoLivingNeighbourShouldDie() {
        createAndMoveCellState(false);
    }

    @Test
    fun aDeadCellWithNoLivingNeighbourShouldRemainDead() {
        createAndMoveCellState(false)
    }

    @Test
    fun aLivingCellWithOneLivingNeighbourShouldDie() {
        createAndMoveCellState(false, true, 1)
    }

    @Test
    fun aDeadCellWithOneLivingNeighbourRemainDead() {
        createAndMoveCellState(false, false, 1)
    }

    @Test
    fun aLivingCellWithTwoLivingNeighbourShouldLiveOn() {
        createAndMoveCellState(true, true, 2)
    }

    @Test
    fun aDeadCellWithTwoLivingNeighboursShouldRemainDead() {
        createAndMoveCellState(false, false, 1)
    }

    @Test
    fun aLivingCellWithThreeLivingNeighbourShouldLiveOn() {
        createAndMoveCellState(true, true, 3)
    }

    @Test
    fun aDeadCellWithThreedLivingNeighboursShouldBecomAlive() {
        createAndMoveCellState(true, false, 3)
    }

    @Test
    fun aLivingCellWithMoreThanThreeLivingNeighbourShouldDie() {
        createAndMoveCellState(false, true, 4)
        createAndMoveCellState(false, true, 5)
    }

    @Test
    fun aDeadCellWithMoreThanThreeLivingNeighboursShouldRemainDead() {
        createAndMoveCellState(false, true, 4)
        createAndMoveCellState(false, true, 5)
    }

    private fun createAndMoveCellState(finalState: Boolean, initialState: Boolean = true, numLivingNeighbours: Int = 0) {
        var cell = Cell(initialState)
        var newCell = cell.nextMove(numLivingNeighbours)
        assertThat(newCell.isAlive).isEqualTo(finalState)
    }

}