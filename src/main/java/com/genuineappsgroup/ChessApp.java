package com.genuineappsgroup;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
                Rectangle square = new Rectangle(93, 93, (row + col) % 2 == 0 ? Color.BEIGE : Color.YELLOWGREEN);
                chessboard.add(square, col, row);
            }
        }

        initializeBoard(chessboard);

        // Create labels
        Label gameNameLabel = new Label("Chess Game");
        gameNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        Label player1Label = new Label("Player 1: Alice");
        player1Label.setFont(Font.font("Arial", 18));
        Label player2Label = new Label("Player 2: Bob");
        player2Label.setFont(Font.font("Arial", 18));

        // Create a VBox to hold the labels
        VBox infoBox = new VBox(10, gameNameLabel, player1Label, player2Label);
        infoBox.setPadding(new Insets(20));
        infoBox.setLayoutX(750);  // Position to the right of the chessboard
        infoBox.setLayoutY(100);  // Position a bit down from the top

        root.getChildren().addAll(chessboard, infoBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeBoard(GridPane chessboard) {
        // Load the piece images
        Image whitePawnImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/white-pawn.png").toExternalForm());
        Image blackPawnImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/black-pawn.png").toExternalForm());

        // Place white pawns
        for (int col = 0; col < 8; col++) {
            ImageView whitePawnView = new ImageView(whitePawnImage);
            whitePawnView.setFitWidth(85);
            whitePawnView.setFitHeight(85);
            chessboard.add(whitePawnView, col, 6); // Place white pawns at row 6
        }

        // Place black pawns
        for (int col = 0; col < 8; col++) {
            ImageView blackPawnView = new ImageView(blackPawnImage);
            blackPawnView.setFitWidth(85);
            blackPawnView.setFitHeight(85);
            chessboard.add(blackPawnView, col, 1); // Place black pawns at row 1
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
