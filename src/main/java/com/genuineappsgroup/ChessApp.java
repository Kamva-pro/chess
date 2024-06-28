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
import javafx.scene.input.TouchEvent;


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

        ImageView whitePawnImageView = new ImageView(whitePawnImage);
        ImageView blackPawnImageView = new ImageView(blackPawnImage);

        ImageView whiteRookImageView = new ImageView(whiteRookImage);
        ImageView blackRookImageView = new ImageView(blackRookImage);

        ImageView whiteKnightImageView = new ImageView(whiteKnightImage);
        ImageView blackKnightImageView = new ImageView(blackKnightImage);

        ImageView whiteBishopImageView = new ImageView(whiteBishopImage);
        ImageView blackBishopImageView = new ImageView(blackBishopImage);

        ImageView whiteQueenImageView = new ImageView(whiteQueenImage);
        ImageView blackQueenImageView = new ImageView(blackQueenImage);

        ImageView whiteKingImageView = new ImageView(whiteKingImage);
        ImageView blackKingImageView = new ImageView(blackKingImage);
         //Initialize the white pawns
        Pawn aPawn = new Pawn(0, 6, true, new ImageView(whitePawnImage));
        Pawn bPawn = new Pawn(1, 6, true, new ImageView(whitePawnImage));
        Pawn cPawn = new Pawn(2, 6, true, new ImageView(whitePawnImage));
        Pawn dPawn = new Pawn(3, 6, true, new ImageView(whitePawnImage));
        Pawn ePawn = new Pawn(4, 6, true, new ImageView(whitePawnImage));
        Pawn fPawn = new Pawn(5, 6, true, new ImageView(whitePawnImage));
        Pawn gPawn = new Pawn(6, 6, true, new ImageView(whitePawnImage));
        Pawn hPawn = new Pawn(7, 6, true, new ImageView(whitePawnImage));
 
         //Initialize the black pawns
         Pawn aPawnBlack = new Pawn(0, 1, false, new ImageView(blackPawnImage));
         Pawn bPawnBlack = new Pawn(1, 1, false, new ImageView(blackPawnImage));
         Pawn cPawnBlack = new Pawn(2, 1, false, new ImageView(blackPawnImage));
         Pawn dPawnBlack = new Pawn(3, 1, false, new ImageView(blackPawnImage));
         Pawn ePawnBlack = new Pawn(4, 1, false, new ImageView(blackPawnImage));
         Pawn fPawnBlack = new Pawn(5, 1, false, new ImageView(blackPawnImage));
         Pawn gPawnBlack = new Pawn(6, 1, false, new ImageView(blackPawnImage));
         Pawn hPawnBlack = new Pawn(7, 1, false, new ImageView(blackPawnImage));
         //initialize the white rooks
         Rook aRook = new Rook(0, 7, true, whiteRookImageView);
         Rook hRook = new Rook(7, 7, true, whiteRookImageView);

         //initialize the black rooks
         Rook aRookBlack = new Rook(0, 0, false, blackRookImageView);
         Rook hRookBlack = new Rook(7, 0, false, blackRookImageView);

         //initialize the white knights
         Knight bKnight = new Knight(1, 7, true, whiteKnightImageView);
         Knight gKnight = new Knight(6, 7, true, whiteKnightImageView);

         //initialize the black knights
         Knight bKnightBlack = new Knight(1, 0, false, blackKnightImageView);
         Knight gKnightBlack = new Knight(6, 0, false, blackKnightImageView);

         //initialize the white bishops
         Bishop cBishop = new Bishop(2, 7, true, whiteBishopImageView);
         Bishop fBishop = new Bishop(5, 7, true, whiteBishopImageView);

         //initialize the black bishops

         Bishop cBishopBlack = new Bishop(2, 0, false, blackBishopImageView);
         Bishop fBishopBlack = new Bishop(5, 0, false, blackBishopImageView);

         //initialize the white queen
         Queen wQueen = new Queen(3, 7, true, whiteQueenImageView);

         //initialize the black queen
         Queen bQueen = new Queen(3, 0, false, blackQueenImageView);

         //initialize the kings
         King wKing = new King(4, 7, true, whiteKingImageView);
         King bKing = new King(4, 0, false, blackKingImageView);
         
        // Place white pieces
        placePiece(chessboard, aRook.image, aRook.x, aRook.y);
        placePiece(chessboard, hRook.image, hRook.x, hRook.y);
        placePiece(chessboard, bKnight.image, bKnight.x, bKnight.y);
        placePiece(chessboard, gKnight.image, gKnight.x, gKnight.y);
        placePiece(chessboard, cBishop.image, cBishop.x, cBishop.y);
        placePiece(chessboard, fBishop.image, fBishop.x, fBishop.y);
        placePiece(chessboard, wQueen.image, wQueen.x, wQueen.y);
        placePiece(chessboard, wKing.image, wKing.x, wKing.y);
        
        //add touch events for white pieces
        pieceTouched(aRook.image, aRook.x, aRook.y, chessboard);
        pieceTouched(hRook.image, hRook.x, hRook.y, chessboard);
        pieceTouched(bKnight.image, bKnight.x, bKnight.y, chessboard);
        pieceTouched(gKnight.image, gKnight.x, gKnight.y, chessboard);
        pieceTouched(cBishop.image, cBishop.x, cBishop.y, chessboard);
        pieceTouched(fBishop.image, fBishop.x, fBishop.y, chessboard);
        pieceTouched(wQueen.image, wQueen.x, wQueen.y, chessboard);
        pieceTouched(wKing.image, wKing.x, wKing.y, chessboard);

        //add touch events for the pawns
        pieceTouched(aPawn.image, aPawn.x, aPawn.y, chessboard);
        pieceTouched(bPawn.image, bPawn.x, bPawn.y, chessboard);
        pieceTouched(cPawn.image, cPawn.x, cPawn.y, chessboard);
        pieceTouched(dPawn.image, dPawn.x, dPawn.y, chessboard);
        pieceTouched(ePawn.image, ePawn.x, ePawn.y, chessboard);
        pieceTouched(fPawn.image, fPawn.x, fPawn.y, chessboard);
        pieceTouched(gPawn.image, gPawn.x, gPawn.y, chessboard);
        pieceTouched(hPawn.image, hPawn.x, hPawn.y, chessboard);


        //add touch events for black pieces



        //place the white pawns on the board
        placePiece(chessboard, aPawn.image, 0, 6);
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
        placePiece(chessboard, cBishopBlack.image, cBishopBlack.x, cBishopBlack.y);
        placePiece(chessboard, fBishopBlack.image, fBishopBlack.x, fBishopBlack.y);
        placePiece(chessboard, bQueen.image, bQueen.x, bQueen.y);
        placePiece(chessboard, bKing.image, bKing.x, bKing.y);
    
        placePiece(chessboard, aPawnBlack.image, aPawnBlack.x, aPawnBlack.y);
        placePiece(chessboard, bPawnBlack.image, bPawnBlack.x, bPawnBlack.y);
        placePiece(chessboard, cPawnBlack.image, cPawnBlack.x, cPawnBlack.y);
        placePiece(chessboard, dPawnBlack.image, dPawnBlack.x, dPawnBlack.y);
        placePiece(chessboard, ePawnBlack.image, ePawnBlack.x, ePawnBlack.y);
        placePiece(chessboard, fPawnBlack.image, fPawnBlack.x, fPawnBlack.y);
        placePiece(chessboard, gPawnBlack.image, gPawnBlack.x, gPawnBlack.y);
        placePiece(chessboard, hPawnBlack.image, hPawnBlack.x, hPawnBlack.y);

    }

    private void pieceTouched(ImageView touchedPiece, int x, int y, GridPane chessboard) {
        touchedPiece.setOnTouchPressed((TouchEvent event) -> {
            // Change the color of the square the piece is on
            Rectangle square = getSquare(chessboard, x, y);
            if (square != null) {
                square.setFill(Color.LIGHTBLUE);
            }
        });
    }

    private Rectangle getSquare(GridPane chessboard, int x, int y) {
        for (javafx.scene.Node node : chessboard.getChildren()) {
            if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y && node instanceof Rectangle) {
                return (Rectangle) node;
            }
        }
        return null;
    }
    private void placePiece(GridPane chessboard, ImageView pieceImage, int col, int row) {
        pieceImage.setFitWidth(85);
        pieceImage.setFitHeight(85);
        
        // Add hover effect and cursor change
        pieceImage.setOnMouseEntered(event -> {
            pieceImage.setOpacity(0.5); // Make the piece slightly transparent
            pieceImage.setCursor(Cursor.HAND); // Change cursor to hand
        });
        pieceImage.setOnMouseExited(event -> {
            pieceImage.setOpacity(1.0); // Restore original opacity
        });

        chessboard.add(pieceImage, col, row);
    }

    public static void main(String[] args) {
        launch(args);

    }
        
}
