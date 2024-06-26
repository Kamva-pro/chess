package com.genuineappsgroup;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chess Game");

        GridPane chessBoard = createChessBoard();

        Scene scene = new Scene(chessBoard, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private GridPane createChessBoard() {
        GridPane grid = new GridPane();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessSquare square = new ChessSquare((row + col) % 2 == 0);
                grid.add(square, col, row);
            }
        }
        return grid;
    }
}
