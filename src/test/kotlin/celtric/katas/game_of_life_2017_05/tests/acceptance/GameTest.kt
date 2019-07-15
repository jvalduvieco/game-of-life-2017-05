package celtric.katas.game_of_life_2017_05.tests.acceptance

import org.junit.Assert.assertEquals
import org.junit.Test

class GameTest : AcceptanceTestCase() {

    @Test
    fun an_empty_universe_does_not_evolve() {
        val game = game(
                3,
                0, 0, 0,
                0, 0, 0)

        assertEquals(game, game.evolve())
    }

    @Test
    fun a_single_live_cell_dies_within_an_iteration() {
        val game = game(
                3,
                0, 0, 0,
                0, a, 0,
                0, 0, 0)

        assertEquals(
                game(
                        3,
                        0, 0, 0,
                        0, 0, 0,
                        0, 0, 0), game.evolve())
    }

    @Test
    fun universe_is_not_constrained_to_visible_grid() {
        val game = game(
                3,
                a, a, a,
                0, 0, 0,
                0, 0, 0)

        assertEquals(
                game(
                        3,
                        a, a, a,
                        0, 0, 0,
                        0, 0, 0), game.evolve(2))
    }
}
