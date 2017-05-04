package celtric.katas.game_of_life_2017_05;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Game {

    private final Set<Coordinate> aliveCells;

    public Game() {
        this.aliveCells = new HashSet<>();
    }

    private Game(Set<Coordinate> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public void addCell(int x, int y) {
        aliveCells.add(new Coordinate(x, y));
    }

    public void removeCell(int x, int y) {
        aliveCells.remove(new Coordinate(x, y));
    }

    public boolean isAlive(int x, int y) {
        return aliveCells.contains(new Coordinate(x, y));
    }

    public Game evolve(int times) {
        return times == 1 ? evolve() : evolve(times - 1).evolve();
    }

    public Game evolve() {
        return new Game(aliveCells.stream()
                .flatMap(c -> c.neighbours().stream())
                .filter(c -> c.isNextGenerationAlive(aliveCells))
                .collect(Collectors.toSet()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            return aliveCells.equals(((Game) obj).aliveCells);
        } else {
            return super.equals(obj);
        }
    }
}
