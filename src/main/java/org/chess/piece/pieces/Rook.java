package org.chess.piece.pieces;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.PieceType;

public class Rook extends Piece {

    public Rook(Color color, int x, int y) {
        super(PieceType.ROOK, color, x, y);
    }

    @Override
    public boolean canMove(int positionX, int positionY, Color pathColor) {
        return canMoveStraight(positionX, positionY, this.currentPosition[1], this.currentPosition[0]);
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color color, Color pathColor) {
        return !this.color.equals(color) && canMoveStraight(positionX, positionY, this.currentPosition[1], this.currentPosition[0]);
    }

    private boolean canMoveStraight(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return positionY == currentPositionY && Math.abs(positionX - currentPositionX) > 0
                || positionX == currentPositionX && Math.abs(positionY - currentPositionY) > 0;
    }
}
