package com.genuineappsgroup;

public abstract class Piece {
    private int x;
    private int y;
    private boolean isWhite; 

    public Piece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public abstract boolean is_blocked();
    public abstract boolean is_check();
    public abstract boolean is_opening();
    public abstract boolean isValidMove(int newX, int newY);   
    public abstract void move();

}

