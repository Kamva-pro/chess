package com.genuineappsgroup;

import javafx.scene.image.Image;


public class Bishop extends Piece {

    public Bishop(int x, int y, boolean isWhite, @SuppressWarnings("exports") Image image) {
        super(x, y, isWhite, image);
        //TODO Auto-generated constructor stub
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
    public void move()
    {
        if(isValidMove(0, 0))
        {
            move();
        }
    }
    
}
