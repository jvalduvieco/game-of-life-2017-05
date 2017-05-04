package celtric.katas.game_of_life_2017_05.tests.acceptance.patterns;

import celtric.katas.game_of_life_2017_05.Game;
import celtric.katas.game_of_life_2017_05.tests.acceptance.AcceptanceTestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class StillLivesTest extends AcceptanceTestCase {

    @Test
    public void block() {
        Game game = game(4,
            0, 0, 0, 0,
            0, A, A, 0,
            0, A, A, 0,
            0, 0, 0, 0);

        assertEquals(game(4,
            0, 0, 0, 0,
            0, A, A, 0,
            0, A, A, 0,
            0, 0, 0, 0), game.evolve());
    }

    @Test
    public void beehive() {
        Game game = game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, A, A, 0, 0,
            0, A, 0, 0, A, 0,
            0, 0, A, A, 0, 0,
            0, 0, 0, 0, 0, 0);

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, A, A, 0, 0,
            0, A, 0, 0, A, 0,
            0, 0, A, A, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve());
    }
}
