package celtric.katas.game_of_life_2017_05;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class Coordinate {

    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Set<Coordinate> neighbours() {
        return range(x).stream()
                .flatMap(x -> range(y).stream().map(y -> new Coordinate(x, y)))
                .filter(coord -> !equals(coord))
                .collect(Collectors.toSet());
    }

    private Set<Integer> range(int n) {
        return IntStream.rangeClosed(n - 1, n + 1).boxed().collect(Collectors.toSet());
    }

    boolean isNextGenerationAlive(Set<Coordinate> aliveCells) {
        return neighbourhood(aliveCells).isNextGenerationAlive(aliveCells.contains(this));
    }

    private Neighbourhood neighbourhood(Set<Coordinate> aliveCells) {
        return Neighbourhood.of((int) neighbours().stream().filter(aliveCells::contains).count());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {
            return x == ((Coordinate) obj).x && y == ((Coordinate) obj).y;
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
