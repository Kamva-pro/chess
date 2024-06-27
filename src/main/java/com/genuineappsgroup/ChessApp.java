package com.genuineappsgroup;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    private String playerOneName;
    private String playerTwoName;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initial screen with text fields for usernames
        TextField playerOneField = new TextField();
        playerOneField.setPromptText("Enter Player 1 Name");
        TextField playerTwoField = new TextField();
        playerTwoField.setPromptText("Enter Player 2 Name");

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> {
            playerOneName = playerOneField.getText();
            playerTwoName = playerTwoField.getText();
            startGame(primaryStage);
        });

        VBox initialLayout = new VBox(10, playerOneField, playerTwoField, startButton);
        initialLayout.setPadding(new Insets(20));
        initialLayout.setLayoutX(100);
        initialLayout.setLayoutY(100);

        Group initialRoot = new Group(initialLayout);
        Scene initialScene = new Scene(initialRoot, 400, 200);
        primaryStage.setScene(initialScene);
        primaryStage.show();
    }

    private void startGame(Stage primaryStage) {
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
        gameNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        Label player1Label = new Label("Player 1: " + playerOneName);
        player1Label.setFont(Font.font("Arial", 24));
        Label player2Label = new Label("Player 2: " + playerTwoName);
        player2Label.setFont(Font.font("Arial", 24));

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

        Image whiteRookImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/white-rook.png").toExternalForm());
        Image blackRookImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/black-rook.png").toExternalForm());

        Image whiteKnightImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/white-knight.png").toExternalForm());
        Image blackKnightImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/black-knight.png").toExternalForm());

        Image whiteBishopImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/white-bishop.png").toExternalForm());
        Image blackBishopImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/black-bishop.png").toExternalForm());

        Image whiteQueenImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/white-queen.png").toExternalForm());
        Image blackQueenImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/black-queen.png").toExternalForm());

        Image whiteKingImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/white-king.png").toExternalForm());
        Image blackKingImage = new Image(getClass().getResource("/com/genuineappsgroup/pieces/black-king.png").toExternalForm());

        // Place white pieces
        placePiece(chessboard, whiteRookImage, 0, 7);
        placePiece(chessboard, whiteRookImage, 7, 7);
        placePiece(chessboard, whiteKnightImage, 1, 7);
        placePiece(chessboard, whiteKnightImage, 6, 7);
        placePiece(chessboard, whiteBishopImage, 2, 7);
        placePiece(chessboard, whiteBishopImage, 5, 7);
        placePiece(chessboard, whiteQueenImage, 3, 7);
        placePiece(chessboard, whiteKingImage, 4, 7);
        for (int col = 0; col < 8; col++) {
            placePiece(chessboard, whitePawnImage, col, 6);
        }

        // Place black pieces
        placePiece(chessboard, blackRookImage, 0, 0);
        placePiece(chessboard, blackRookImage, 7, 0);
        placePiece(chessboard, blackKnightImage, 1, 0);
        placePiece(chessboard, blackKnightImage, 6, 0);
        placePiece(chessboard, blackBishopImage, 2, 0);
        placePiece(chessboard, blackBishopImage, 5, 0);
        placePiece(chessboard, blackQueenImage, 3, 0);
        placePiece(chessboard, blackKingImage, 4, 0);
        for (int col = 0; col < 8; col++) {
            placePiece(chessboard, blackPawnImage, col, 1);
        }
    }

    private void placePiece(GridPane chessboard, Image pieceImage, int col, int row) {
        ImageView pieceView = new ImageView(pieceImage);
        pieceView.setFitWidth(85);
        pieceView.setFitHeight(85);
        
        // Add hover effect and cursor change
        pieceView.setOnMouseEntered(event -> {
            pieceView.setOpacity(0.7); // Make the piece slightly transparent
            pieceView.setCursor(Cursor.HAND); // Change cursor to hand
        });
        pieceView.setOnMouseExited(event -> {
            pieceView.setOpacity(1.0); // Restore original opacity
        });

        chessboard.add(pieceView, col, row);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
