package celtric.katas.game_of_life_2017_05.ui;

import celtric.katas.game_of_life_2017_05.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

// Note: quick UI implementation to display cells
public final class App extends Application {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 70;
    private static final int CELL_SIZE = 10;

    private final Set<Coordinate> grid = new HashSet<>();
    private Game game = new Game();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        fillGrid(WIDTH, HEIGHT);

        StackPane root = new StackPane();
        root.setId("root");
        Scene scene = new Scene(root, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        root.getChildren().add(board());
        primaryStage.setTitle("Game of Life");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, k -> {
            if (k.getCode() == KeyCode.SPACE) {
                game = game.evolve();
                reprintGrid();
            }
        });
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, k -> {
            if (k.getCode() == KeyCode.BACK_SPACE) {
                game = new Game();
                reprintGrid();
            }
        });

        reprintGrid();
    }

    private void reprintGrid() {
        grid.forEach(c -> {
            if (game.isAlive(c.x, c.y)) {
                c.rectangle.setFill(Color.BLACK);
            } else {
                c.rectangle.setFill(Color.TRANSPARENT);
            }
        });
    }

    private GridPane board() {
        GridPane boardSpace = new GridPane();
        boardSpace.setGridLinesVisible(true);

        grid.forEach(c -> {
            c.rectangle.setOnMouseClicked(event -> {
                if (this.game.isAlive(c.x, c.y)) {
                    this.game.removeCell(c.x, c.y);
                } else {
                    this.game.addCell(c.x, c.y);
                }
                reprintGrid();
            });
            boardSpace.add(c.rectangle, c.x, c.y);
        });

        return boardSpace;
    }

    private void fillGrid(int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid.add(new Coordinate(x, y, new Rectangle(CELL_SIZE, CELL_SIZE, Color.TRANSPARENT)));
            }
        }
    }
}

final class Coordinate {

    final int x;
    final int y;
    final Rectangle rectangle;

    Coordinate(int x, int y, Rectangle rectangle) {
        this.x = x;
        this.y = y;
        this.rectangle = rectangle;
    }
}
