package celtric.katas.game_of_life_2017_05.tests.acceptance.patterns

import celtric.katas.game_of_life_2017_05.tests.acceptance.AcceptanceTestCase
import org.junit.Assert.assertEquals
import org.junit.Test

class StillLivesTest : AcceptanceTestCase() {

    @Test
    fun block() {
        val game = game(
                4,
                0, 0, 0, 0,
                0, a, a, 0,
                0, a, a, 0,
                0, 0, 0, 0)

        assertEquals(
                game(
                        4,
                        0, 0, 0, 0,
                        0, a, a, 0,
                        0, a, a, 0,
                        0, 0, 0, 0), game.evolve())
    }

    @Test
    fun beehive() {
        val game = game(
                6,
                0, 0, 0, 0, 0, 0,
                0, 0, a, a, 0, 0,
                0, a, 0, 0, a, 0,
                0, 0, a, a, 0, 0,
                0, 0, 0, 0, 0, 0)

        assertEquals(
                game(
                        6,
                        0, 0, 0, 0, 0, 0,
                        0, 0, a, a, 0, 0,
                        0, a, 0, 0, a, 0,
                        0, 0, a, a, 0, 0,
                        0, 0, 0, 0, 0, 0), game.evolve())
    }
}
