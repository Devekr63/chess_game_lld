package org.chess.piece;

import org.chess.game.Color;

public abstract class Piece implements Movement {
    protected PieceType type;
    protected Color color;
    protected int[] currentPosition = new int[2];

    public Piece(PieceType type, Color color, int x, int y) {
        this.type = type;
        this.color = color;
        currentPosition[1] = x;
        currentPosition[0] = y;
    }

    protected void jumpToNewPosition(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }

    public int getPositionX() {
        return currentPosition[1];
    }

    public void setPositionX(int currentPositionX) {
        this.currentPosition[1] = currentPositionX;
    }

    public int getPositionY() {
        return currentPosition[0];
    }

    public void setPositionY(int currentPositionY) {
        this.currentPosition[0] = currentPositionY;
    }

    public Color getColor() {
        return color;
    }
}
