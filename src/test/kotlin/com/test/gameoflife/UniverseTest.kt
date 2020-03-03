package com.test.gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class UniverseTest{
    val UNIVERS_SIZE = 3
    @Test
    fun a2DimensionalUniverseShouldBeCreatedWithAllDeadCells(){
        val universe = Universe(UNIVERS_SIZE)
        assertThat(universe.cells.size).isEqualTo(UNIVERS_SIZE)
        assertThat(universe.cells[0].size).isEqualTo(UNIVERS_SIZE)
        validateUniverseState(UNIVERS_SIZE, universe)
    }

    private fun validateUniverseState(universeSize: Int, universe: Universe) {
        for (row in 0 until universeSize) {
            for (column in 0 until universeSize) {
                assertThat(universe.cells[row][column].isAlive).isEqualTo(false)
            }
        }
    }

    @Test
    fun universeIsStartedWithLiveCells(){
        val universe = Universe(UNIVERS_SIZE)
        universe.startUniverse(Pair(0,1),Pair(2,1))
        assertThat(universe.cells[0][1].isAlive).isEqualTo(true)
        assertThat(universe.cells[2][1].isAlive).isEqualTo(true)
    }







}