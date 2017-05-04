package celtric.katas.game_of_life_2017_05.tests.acceptance;

import celtric.katas.game_of_life_2017_05.Game;
import org.junit.Test;

import static org.junit.Assert.*;

public final class GameTest extends AcceptanceTestCase {

    @Test
    public void an_empty_universe_does_not_evolve() {
        Game game = game(3,
            0, 0, 0,
            0, 0, 0);

        assertEquals(game, game.evolve());
    }

    @Test
    public void a_single_live_cell_dies_within_an_iteration() {
        Game game = game(3,
            0, 0, 0,
            0, A, 0,
            0, 0, 0);

        assertEquals(game(3,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0), game.evolve());
    }

    @Test
    public void universe_is_not_constrained_to_visible_grid() {
        Game game = game(3,
            A, A, A,
            0, 0, 0,
            0, 0, 0);

        assertEquals(game(3,
            A, A, A,
            0, 0, 0,
            0, 0, 0), game.evolve(2));
    }
}
