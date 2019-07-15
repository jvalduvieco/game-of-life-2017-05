package celtric.katas.game_of_life_2017_05

import java.util.*

data class Game (private val aliveCells: MutableSet<Coordinate> = emptySet<Coordinate>().toMutableSet()){
    fun addCell(x: Int, y: Int) {
        aliveCells.add(Coordinate(x, y))
    }

    fun removeCell(x: Int, y: Int) {
        aliveCells.remove(Coordinate(x, y))
    }

    fun isAlive(x: Int, y: Int): Boolean {
        return aliveCells.contains(Coordinate(x, y))
    }

    fun evolve(times: Int): Game {
        return if (times == 1) evolve() else evolve(times - 1).evolve()
    }

    fun evolve(): Game {
        return Game(
                aliveCells
                        .flatMap { c -> c.neighbours() }
                        .filter { c -> c.isNextGenerationAlive(aliveCells) }
                        .toMutableSet())
    }
}
