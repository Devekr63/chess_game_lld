package org.chess.piece;

import org.chess.game.Color;

public abstract class Piece {
    protected PieceType type;
    protected Color color;

    protected int[] currentPosition = new int[2];

    public Piece(PieceType type, Color color, int x, int y){
        this.type = type;
        this.color = color;
        currentPosition[1] = x;
        currentPosition[0] = y;
    }

    public void setCurrentPositionX(int currentPositionX){
        this.currentPosition[1] = currentPositionX;
    }

    public void setCurrentPositionY(int currentPositionY){
        this.currentPosition[0] = currentPositionY;
    }
}
