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
                assertThat(cell.isAlive).isFalse()
            }
        }
    }

    @Test
    fun universeShouldStayTheSameWithBeeHive() {
        val universe = Universe(4)
        universe.startUniverse(
            Pair(0,1),Pair(0,2),
            Pair(1,0),Pair(1,3),
            Pair(2,1), Pair(2,2)
        )

        universe.evolve()
        assertThat(universe.cells[0][1].isAlive).isTrue()
        assertThat(universe.cells[0][2].isAlive).isTrue()
        assertThat(universe.cells[1][0].isAlive).isTrue()
        assertThat(universe.cells[1][3].isAlive).isTrue()
        assertThat(universe.cells[2][1].isAlive).isTrue()
        assertThat(universe.cells[2][2].isAlive).isTrue()

    }

    @Test
    fun universeIsStartedWithOnlyValidLiveCells() {
        val universe = Universe(3)
        assertAllCellsAreDead(universe)
        universe.startUniverse(Pair(-1, 1), Pair(2, 1))
        assertThat(universe.cells[2][1].isAlive).isTrue()
        universe.evolve()
    }

    @Test
    fun universeBlockShouldNotChange() {
        val universe = Universe(2)
        assertAllCellsAreDead(universe)
        universe.startUniverse(Pair(0, 0), Pair(0, 1),
                Pair(1, 0), Pair(1, 1))
        assertThat(universe.cells[1][1].isAlive).isTrue()
        universe.evolve()
        assertThat(universe.cells[1][1].isAlive).isTrue()
        universe.cells.forEach { row ->
            row.forEach { cell ->
                assertThat(cell.isAlive).isTrue()
            }
        }
    }



    @Test
    fun test8x8Glider() {
        val universe = Universe(8)
        assertAllCellsAreDead(universe)

        universe.startUniverse(Pair(3, 3), Pair(4, 4),
                Pair(5, 2), Pair(5, 3), Pair(5,4))
        assertThat(universe.cells[3][3].isAlive).isTrue()
        assertThat(universe.cells[4][4].isAlive).isTrue()
        assertThat(universe.cells[5][2].isAlive).isTrue()
        assertThat(universe.cells[5][3].isAlive).isTrue()
        assertThat(universe.cells[5][4].isAlive).isTrue()

        universe.evolve()

        assertThat(universe.cells[3][3].isAlive).isFalse()
        assertThat(universe.cells[5][2].isAlive).isFalse()

        assertThat(universe.cells[4][2].isAlive).isTrue()
        assertThat(universe.cells[4][4].isAlive).isTrue()
        assertThat(universe.cells[5][3].isAlive).isTrue()
        assertThat(universe.cells[5][4].isAlive).isTrue()
        assertThat(universe.cells[6][3].isAlive).isTrue()

        universe.evolve()

        assertThat(universe.cells[5][3].isAlive).isFalse()
        assertThat(universe.cells[4][2].isAlive).isFalse()

        assertThat(universe.cells[4][4].isAlive).isTrue()
        assertThat(universe.cells[5][2].isAlive).isTrue()
        assertThat(universe.cells[5][4].isAlive).isTrue()
        assertThat(universe.cells[6][3].isAlive).isTrue()
        assertThat(universe.cells[6][4].isAlive).isTrue()
    }



}