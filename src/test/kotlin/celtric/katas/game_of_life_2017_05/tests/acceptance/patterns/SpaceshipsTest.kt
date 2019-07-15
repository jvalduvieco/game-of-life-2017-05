package celtric.katas.game_of_life_2017_05.tests.acceptance.patterns

import celtric.katas.game_of_life_2017_05.tests.acceptance.AcceptanceTestCase
import org.junit.Assert.assertEquals
import org.junit.Test

class SpaceshipsTest : AcceptanceTestCase() {

    @Test
    fun glider() {
        val game = game(
                4,
                0, a, 0, 0,
                0, 0, a, 0,
                a, a, a, 0,
                0, 0, 0, 0)

        assertEquals(
                game(
                        4,
                        0, 0, 0, 0,
                        a, 0, a, 0,
                        0, a, a, 0,
                        0, a, 0, 0), game.evolve())

        assertEquals(
                game(
                        4,
                        0, 0, 0, 0,
                        0, 0, a, 0,
                        a, 0, a, 0,
                        0, a, a, 0), game.evolve(2))

        assertEquals(
                game(
                        4,
                        0, 0, 0, 0,
                        0, a, 0, 0,
                        0, 0, a, a,
                        0, a, a, 0), game.evolve(3))

        assertEquals(
                game(
                        4,
                        0, 0, 0, 0,
                        0, 0, a, 0,
                        0, 0, 0, a,
                        0, a, a, a), game.evolve(4))
    }
}
