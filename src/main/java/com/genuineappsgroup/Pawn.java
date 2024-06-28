package com.genuineappsgroup;

import javafx.scene.image.Image;

public class Pawn extends Piece {
    int x;
    int y;
    private int movement_squares;
    Image image;

    public Pawn(int x, int y, boolean isWhite, Image image) {
        super(x, y, isWhite, image);
        this.x = x;
        this.y = y;
        this.image = image;
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        if (!is_opening() && movement_squares > 1) return false;
        else if(is_check() || is_blocked()) return false;
        else return true;
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

    public Image getImage() {
        return this.image;
    }

    @Override
    public boolean is_blocked() {
        throw new UnsupportedOperationException("Unimplemented method 'is_blocked'");
    }

    @Override
    public boolean is_check() {
        throw new UnsupportedOperationException("Unimplemented method 'is_check'");
    }

    @Override
    public boolean is_opening() {
        throw new UnsupportedOperationException("Unimplemented method 'is_opening'");
    }

    @Override
    public void move() {
        y++;
    }
}
