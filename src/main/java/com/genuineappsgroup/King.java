package com.genuineappsgroup;

public class King extends Piece {
    int current_x, current_y;
    int movement_squares;
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
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
