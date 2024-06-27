package com.genuineappsgroup;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessSquare extends StackPane {
    private final int size = 100;

    public ChessSquare(boolean isLight) {
        Rectangle square = new Rectangle(size, size);
        square.setFill(isLight ? Color.BEIGE : Color.BROWN);
        getChildren().add(square);
    }
}
