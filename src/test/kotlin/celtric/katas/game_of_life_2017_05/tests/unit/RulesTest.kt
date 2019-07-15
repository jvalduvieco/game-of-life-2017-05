package celtric.katas.game_of_life_2017_05.tests.unit

import celtric.katas.game_of_life_2017_05.Neighbourhood
import org.junit.Test

import org.junit.Assert.*

class RulesTest {

    @Test
    fun any_live_cell_with_fewer_than_two_live_neighbours_dies_as_if_caused_by_underpopulation() {
        assertFalse(Neighbourhood.of(0).isNextGenerationAlive(true))
        assertFalse(Neighbourhood.of(1).isNextGenerationAlive(true))
    }

    @Test
    fun any_live_cell_with_two_or_three_live_neighbours_lives_on_to_the_next_generation() {
        assertTrue(Neighbourhood.of(2).isNextGenerationAlive(true))
        assertTrue(Neighbourhood.of(3).isNextGenerationAlive(true))
    }

    @Test
    fun any_live_cell_with_more_than_three_live_neighbours_dies_as_if_by_overpopulation() {
        assertFalse(Neighbourhood.of(4).isNextGenerationAlive(true))
        assertFalse(Neighbourhood.of(8).isNextGenerationAlive(true))
    }

    @Test
    fun any_dead_cell_with_exactly_three_live_neighbours_becomes_a_live_cell_as_if_by_reproduction() {
        assertTrue(Neighbourhood.of(3).isNextGenerationAlive(false))
    }

    @Test
    fun any_dead_cell_remains_dead_if_not_located_in_a_fertile_neighbourhood() {
        assertFalse(Neighbourhood.of(2).isNextGenerationAlive(false))
        assertFalse(Neighbourhood.of(4).isNextGenerationAlive(false))
    }
}
