package celtric.katas.game_of_life_2017_05

class Neighbourhood private constructor(private val numberOfLiveCells: Int) {

    private val isStable: Boolean
        get() = numberOfLiveCells == 2 || numberOfLiveCells == 3

    private val isFertile: Boolean
        get() = numberOfLiveCells == 3

    fun isNextGenerationAlive(currentlyAlive: Boolean): Boolean {
        return if (currentlyAlive) isStable else isFertile
    }

    companion object {

        fun of(numberOfLiveCells: Int): Neighbourhood {
            return Neighbourhood(numberOfLiveCells)
        }
    }
}
