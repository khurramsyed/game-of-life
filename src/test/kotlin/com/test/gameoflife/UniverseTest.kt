package com.test.gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class UniverseTest {
    val UNIVERS_SIZE = 3
    @Test
    fun a2DimensionalUniverseShouldBeCreatedWithAllDeadCells() {
        val universe = Universe(UNIVERS_SIZE)
        assertThat(universe.cells.size).isEqualTo(UNIVERS_SIZE)
        assertThat(universe.cells[0].size).isEqualTo(UNIVERS_SIZE)
        assertAllCellsAreDead(universe)
    }

    private fun assertAllCellsAreDead(universe: Universe) {
        universe.cells.forEach { row ->
            row.forEach { cell ->
                assertThat(cell.isAlive).isEqualTo(false)
            }
        }
    }

    @Test
    fun universeIsStartedWithLiveCells() {
        val universe = Universe(UNIVERS_SIZE)
        universe.startUniverse(Pair(0, 1), Pair(2, 1))
        assertThat(universe.cells[0][1].isAlive).isEqualTo(true)
        assertThat(universe.cells[2][1].isAlive).isEqualTo(true)
    }

    @Test
    fun universeIsStartedWithOnlyValidLiveCells() {
        val universe = Universe(UNIVERS_SIZE)
        assertAllCellsAreDead(universe)
        universe.startUniverse(Pair(-1, 1), Pair(2, 1))
        assertThat(universe.cells[2][1].isAlive).isEqualTo(true)
    }

}