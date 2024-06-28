package com.genuineappsgroup;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {
    private int x;
    private int y;
    private boolean isWhite; 
    private ImageView image;

    public Piece(int x, int y, boolean isWhitem, ImageView image) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.image = image;
    }

    public void setX(int currentX)
    {
        this.x = currentX;
    }

    public void setY(int currentY)
    {
        this.y = currentY;
    }

    public int getX(){
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public ImageView getImage()
    {
        return this.image;
    }

    public abstract boolean is_blocked();
    public abstract boolean is_check();
    public abstract boolean is_opening();
    public abstract boolean isValidMove(int newX, int newY);   
    public abstract void move();


    

    // Getters and setters for x, y, isWhite
    // Methods for drawing/rendering the piece on the GUI
}

