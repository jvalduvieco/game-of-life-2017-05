package celtric.katas.game_of_life_2017_05

data class Coordinate(private val x: Int, private val y: Int) {

    fun neighbours(): Set<Coordinate> {
        return range(x).flatMap { x -> range(y).map { y -> Coordinate(x, y) } }
                .filter { coord -> !equals(coord) }.toSet()
    }

    private fun range(n: Int): Set<Int> {
        return (n - 1 .. n + 1).toSet()
    }

    fun isNextGenerationAlive(aliveCells: Set<Coordinate>): Boolean {
        return neighbourhood(aliveCells).isNextGenerationAlive(aliveCells.contains(this))
    }

    private fun neighbourhood(aliveCells: Set<Coordinate>): Neighbourhood {
        return Neighbourhood.of(neighbours().filter { aliveCells.contains(it) }.count())
    }
}
