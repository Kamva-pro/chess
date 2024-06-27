package com.genuineappsgroup;

public class Pawn extends Piece {
    int x, y;
    int movement_squares;
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
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
        if (isValidMove(x, y)) move();
    }
    // Additional methods specific to pawn behavior
}
