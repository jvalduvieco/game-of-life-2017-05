package celtric.katas.game_of_life_2017_05.tests.acceptance.patterns;

import celtric.katas.game_of_life_2017_05.Game;
import celtric.katas.game_of_life_2017_05.tests.acceptance.AcceptanceTestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class OscillatorsTest extends AcceptanceTestCase {

    @Test
    public void blinker() {
        Game game = game(3,
            0, A, 0,
            0, A, 0,
            0, A, 0);

        assertEquals(game(3,
            0, 0, 0,
            A, A, A,
            0, 0, 0), game.evolve());

        assertEquals(game(3,
            0, A, 0,
            0, A, 0,
            0, A, 0), game.evolve(2));
    }

    @Test
    public void toad() {
        Game game = game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, A, A, A, 0,
            0, A, A, A, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0);

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, A, 0, 0,
            0, A, 0, 0, A, 0,
            0, A, 0, 0, A, 0,
            0, 0, A, 0, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve());

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, A, A, A, 0,
            0, A, A, A, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve(2));
    }
}
