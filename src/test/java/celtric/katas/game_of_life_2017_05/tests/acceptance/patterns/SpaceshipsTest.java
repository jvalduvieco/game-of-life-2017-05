package celtric.katas.game_of_life_2017_05.tests.acceptance.patterns;

import celtric.katas.game_of_life_2017_05.Game;
import celtric.katas.game_of_life_2017_05.tests.acceptance.AcceptanceTestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class SpaceshipsTest extends AcceptanceTestCase {

    @Test
    public void glider() {
        Game game = game(4,
            0, A, 0, 0,
            0, 0, A, 0,
            A, A, A, 0,
            0, 0, 0, 0);

        assertEquals(game(4,
            0, 0, 0, 0,
            A, 0, A, 0,
            0, A, A, 0,
            0, A, 0, 0), game.evolve());

        assertEquals(game(4,
            0, 0, 0, 0,
            0, 0, A, 0,
            A, 0, A, 0,
            0, A, A, 0), game.evolve(2));

        assertEquals(game(4,
            0, 0, 0, 0,
            0, A, 0, 0,
            0, 0, A, A,
            0, A, A, 0), game.evolve(3));

        assertEquals(game(4,
            0, 0, 0, 0,
            0, 0, A, 0,
            0, 0, 0, A,
            0, A, A, A), game.evolve(4));
    }
}
