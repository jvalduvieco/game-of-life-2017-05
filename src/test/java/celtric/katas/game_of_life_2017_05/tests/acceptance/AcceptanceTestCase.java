package celtric.katas.game_of_life_2017_05.tests.acceptance;

import celtric.katas.game_of_life_2017_05.Game;

public abstract class AcceptanceTestCase {

    protected static final int A = 1;

    protected Game game(int width, int... cellStates) {
        Game game = new Game();

        for (int i = 0, x = 0, y = 0; i < cellStates.length; i++, x++) {
            if (x == width) {
                x = 0;
                y++;
            }
            if (cellStates[i] == 1) {
                game.addCell(x, y);
            }
        }
        return game;
    }
}
