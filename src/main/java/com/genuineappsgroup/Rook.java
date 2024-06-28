package com.genuineappsgroup;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece{
    int x, y;
    int movement_squares;
    ImageView image;
    public Rook(int x, int y, boolean isWhite, ImageView img) {
        super(x, y, isWhite, img);
        this.x = x;
        this.y = y;
        this.image = img;
        //TODO Auto-generated constructor stub
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
    public boolean isValidMove(int newX, int newY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidMove'");
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
