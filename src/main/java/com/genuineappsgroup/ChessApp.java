package com.genuineappsgroup;

import java.util.Scanner;

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
        // initialLayout.setLayoutY(100);

        Group initialRoot = new Group(initialLayout);
        Scene initialScene = new Scene(initialRoot, 400, 250);
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

         //Initialize the white pawns
         Pawn aPawn = new Pawn(0, 1, true, whitePawnImage);
         Pawn bPawn = new Pawn(1, 1, true, whitePawnImage);
         Pawn cPawn = new Pawn(2, 1, true, whitePawnImage);
         Pawn dPawn = new Pawn(3, 1, true, whitePawnImage);
         Pawn ePawn = new Pawn(4, 1, true, whitePawnImage);
         Pawn fPawn = new Pawn(5, 1, true, whitePawnImage);
         Pawn gPawn = new Pawn(6, 1, true, whitePawnImage);
         Pawn hPawn = new Pawn(7, 1, true, whitePawnImage);
 
         //Initialize the black pawns
         Pawn aPawnBlack = new Pawn(0, 6, false, blackPawnImage);
         Pawn bPawnBlack = new Pawn(1, 6, false, blackPawnImage);
         Pawn cPawnBlack = new Pawn(2, 6, false, blackPawnImage);
         Pawn dPawnBlack = new Pawn(3, 6, false, blackPawnImage);
         Pawn ePawnBlack = new Pawn(4, 6, false, blackPawnImage);
         Pawn fPawnBlack = new Pawn(5, 6, false, blackPawnImage);
         Pawn gPawnBlack = new Pawn(6, 6, false, blackPawnImage);
         Pawn hPawnBlack = new Pawn(7, 6, false, blackPawnImage);

         //initialize the white rooks
         Rook aRook = new Rook(0, 7, true, whiteRookImage);
         Rook hRook = new Rook(7, 7, true, whiteRookImage);

         //initialize the black rooks
         Rook aRookBlack = new Rook(0, 0, false, blackRookImage);
         Rook hRookBlack = new Rook(7, 0, false, blackRookImage);

         //initialize the white knights
         Knight bKnight = new Knight(1, 7, true, whiteKnightImage);
         Knight gKnight = new Knight(6, 7, true, whiteKnightImage);

         //initialize the black knights
         Knight bKnightBlack = new Knight(1, 0, false, blackKnightImage);
         Knight gKnightBlack = new Knight(6, 0, false, blackKnightImage);

         //initialize the white bishops
         Bishop cBishop = new Bishop(2, 7, true, whiteBishopImage);
         Bishop fBishop = new Bishop(5, 7, true, whiteBishopImage);

         //initialize the black bishops

         Bishop cBishopBlack = new Bishop(2, 0, false, blackBishopImage);
         Bishop fBishopBlack = new Bishop(5, 0, false, blackBishopImage);
         
        // Place white pieces
        placePiece(chessboard, aRook.image, aRook.x, aRook.x);
        placePiece(chessboard, aRook.image, hRook.x, hRook.x);
        placePiece(chessboard, bKnight.image, bKnight.x, bKnight.y);
        placePiece(chessboard, gKnight.image, gKnight.x, gKnight.y);
        placePiece(chessboard, cBishop.image, cBishop.x, cBishop.y);
        placePiece(chessboard, fBishop.image, fBishop.x, fBishop.y);
        placePiece(chessboard, whiteQueenImage, 3, 7);
        placePiece(chessboard, whiteKingImage, 4, 7);
        
        //place the white pawns on the board
        placePiece(chessboard, aPawn.image, aPawn.x, aPawn.y);
        placePiece(chessboard, bPawn.image, bPawn.x, bPawn.y);
        placePiece(chessboard, cPawn.image, cPawn.x, cPawn.y);
        placePiece(chessboard, dPawn.image, dPawn.x, dPawn.y);
        placePiece(chessboard, ePawn.image, ePawn.x, ePawn.y);
        placePiece(chessboard, fPawn.image, fPawn.x, fPawn.y);
        placePiece(chessboard, gPawn.image, gPawn.x, gPawn.y);
        placePiece(chessboard, hPawn.image, hPawn.x, hPawn.y);

        // Place black pieces
        placePiece(chessboard, aRookBlack.image, aRookBlack.x, aRookBlack.y);
        placePiece(chessboard, hRookBlack.image, hRookBlack.x, hRookBlack.y);
        placePiece(chessboard, bKnightBlack.image, bKnightBlack.x, bKnightBlack.y);
        placePiece(chessboard, gKnightBlack.image, gKnightBlack.x, gKnightBlack.y);
        placePiece(chessboard, blackBishopImage, 2, 0);
        placePiece(chessboard, blackBishopImage, 5, 0);
        placePiece(chessboard, blackQueenImage, 3, 0);
        placePiece(chessboard, blackKingImage, 4, 0);
    
        placePiece(chessboard, aPawnBlack.image, aPawnBlack.x, aPawnBlack.y);
        placePiece(chessboard, bPawnBlack.image, bPawnBlack.x, bPawnBlack.y);
        placePiece(chessboard, cPawnBlack.image, cPawnBlack.x, cPawnBlack.y);
        placePiece(chessboard, dPawnBlack.image, dPawnBlack.x, dPawnBlack.y);
        placePiece(chessboard, ePawnBlack.image, ePawnBlack.x, ePawnBlack.y);
        placePiece(chessboard, fPawnBlack.image, fPawnBlack.x, fPawnBlack.y);
        placePiece(chessboard, gPawnBlack.image, gPawnBlack.x, gPawnBlack.y);
        placePiece(chessboard, hPawnBlack.image, hPawnBlack.x, hPawnBlack.y);

    }

    

    private void placePiece(GridPane chessboard, Image pieceImage, int col, int row) {
        ImageView pieceView = new ImageView(pieceImage);
        pieceView.setFitWidth(85);
        pieceView.setFitHeight(85);
        
        // Add hover effect and cursor change
        pieceView.setOnMouseEntered(event -> {
            pieceView.setOpacity(0.5); // Make the piece slightly transparent
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
