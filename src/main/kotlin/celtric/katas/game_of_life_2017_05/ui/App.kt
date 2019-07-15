package celtric.katas.game_of_life_2017_05.ui

import celtric.katas.game_of_life_2017_05.Game
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage

import java.util.HashSet

// Note: quick UI implementation to display cells
class App : Application() {

    private val grid = HashSet<Coordinate>()
    private var game = Game()

    override fun start(primaryStage: Stage) {
        fillGrid(WIDTH, HEIGHT)

        val root = StackPane()
        root.id = "root"
        val scene = Scene(root, (WIDTH * CELL_SIZE).toDouble(), (HEIGHT * CELL_SIZE).toDouble())
        root.children.add(board())
        primaryStage.title = "Game of Life"
        primaryStage.isResizable = false
        primaryStage.scene = scene
        primaryStage.show()
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED) { k ->
            if (k.code == KeyCode.SPACE) {
                game = game.evolve()
                reprintGrid()
            }
        }
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED) { k ->
            if (k.code == KeyCode.BACK_SPACE) {
                game = Game()
                reprintGrid()
            }
        }

        reprintGrid()
    }

    private fun reprintGrid() {
        grid.forEach { c ->
            if (game.isAlive(c.x, c.y)) {
                c.rectangle.fill = Color.BLACK
            } else {
                c.rectangle.fill = Color.TRANSPARENT
            }
        }
    }

    private fun board(): GridPane {
        val boardSpace = GridPane()
        boardSpace.isGridLinesVisible = true

        grid.forEach { c ->
            c.rectangle.setOnMouseClicked {
                if (this.game.isAlive(c.x, c.y)) {
                    this.game.removeCell(c.x, c.y)
                } else {
                    this.game.addCell(c.x, c.y)
                }
                reprintGrid()
            }
            boardSpace.add(c.rectangle, c.x, c.y)
        }

        return boardSpace
    }

    private fun fillGrid(width: Int, height: Int) {
        for (y in 0 until height) {
            for (x in 0 until width) {
                grid.add(Coordinate(x, y, Rectangle(CELL_SIZE.toDouble(), CELL_SIZE.toDouble(), Color.TRANSPARENT)))
            }
        }
    }

    companion object {

        private const val WIDTH = 100
        private const val HEIGHT = 70
        private const val CELL_SIZE = 10

        @JvmStatic fun main(args: Array<String>) {
            launch(*args)
        }
    }
}

internal class Coordinate(val x: Int, val y: Int, val rectangle: Rectangle)
