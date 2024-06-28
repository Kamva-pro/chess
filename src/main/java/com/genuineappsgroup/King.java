package com.genuineappsgroup;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece {
    int x, y;
    int movement_squares;
    ImageView image;
    boolean isWhite;
    public King(int x, int y, boolean isWhite, ImageView image) {
        super(x, y, isWhite, image);
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void setX(int currentX) {
        this.x = currentX;
    }

    public void setY(int currentY) {
        this.y = currentY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageView getImage() {
        return this.image;
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        if (!is_blocked() && !is_check() && movement_squares == 1) return true;
        else return false;
    }

    @Override
    public boolean is_blocked() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'is_blocked'");
    }

    @Override
    public boolean is_check() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'is_check'");
    }

    @Override
    public boolean is_opening() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'is_opening'");
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
