package com.genuineappsgroup;

import javafx.scene.image.Image;

public class Pawn extends Piece {
    int x, y;
    int movement_squares;
    Image image;
    public Pawn(int x, int y, boolean isWhite, Image image) {
        super(x, y, isWhite, image);
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        if (!is_opening() && movement_squares > 1) return false;
        else if(is_check() || is_blocked()) return false;
        else return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage()
    {
        return image;
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
    public void move(){
        y++;
    }
    // Additional methods specific to pawn behavior
}
