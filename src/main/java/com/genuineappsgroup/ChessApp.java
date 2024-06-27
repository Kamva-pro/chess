package com.genuineappsgroup;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1360, 740);

        // Create a chessboard grid
        GridPane chessboard = new GridPane();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle square = new Rectangle(93,93, (row + col) % 2 == 0 ? Color.BLACK : Color.LIGHTGREEN);
                chessboard.add(square, col, row);
                
            }
        }

        // Load the piece images
        Image whitePawnImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/white_pawn.png").toExternalForm());
        Image blackPawnImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/black_pawn.png").toExternalForm());

        // Create and place a pawn on the board
        ImageView whitePawnView = new ImageView(whitePawnImage);
        whitePawnView.setFitWidth(50);
        whitePawnView.setFitHeight(50);
        chessboard.add(whitePawnView, 0, 6); // Place white pawn at initial position (row 6, column 0)

        ImageView blackPawnView = new ImageView(blackPawnImage);
        blackPawnView.setFitWidth(50);
        blackPawnView.setFitHeight(50);
        chessboard.add(blackPawnView, 0, 1); // 

        // Example: Create and place a pawn on the board
        // Pawn pawn = new Pawn(1, 1, true);
        // Rectangle pawnShape = new Rectangle(50, 50, Color.RED);
        // chessboard.add(pawnShape, pawn.getX(), pawn.getY());

        root.getChildren().add(chessboard);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
