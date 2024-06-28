package com.genuineappsgroup;

import javafx.scene.image.Image;

public abstract class Piece {
    private int x;
    private int y;
    private boolean isWhite; 
    private Image image;

    public Piece(int x, int y, boolean isWhitem, Image image) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.image = image;
    }

    public abstract boolean is_blocked();
    public abstract boolean is_check();
    public abstract boolean is_opening();
    public abstract boolean isValidMove(int newX, int newY);   
    public abstract void move();


    

    // Getters and setters for x, y, isWhite
    // Methods for drawing/rendering the piece on the GUI
}

