package org.chess.piece.pieces;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.PieceType;

public class King extends Piece {
    public King(Color color, int x, int y) {
        super(PieceType.KING, color, x, y);
    }

    @Override
    public boolean canMove(int positionX, int positionY, Color pathColor) {
        int currentPositionX = this.currentPosition[1];
        int currentPositionY = this.currentPosition[0];

        return canMoveDiagonal(positionX, positionY, currentPositionX, currentPositionY)
                || canMoveAdjacent(positionX, positionY, currentPositionX, currentPositionY);
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color color, Color pathColor) {
        return !this.color.equals(color) && canMove(positionX, positionY, pathColor);
    }

    private boolean canMoveDiagonal(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return Math.abs(currentPositionX - positionX) == 1 && Math.abs(currentPositionY - positionY) == 1;
    }

    private boolean canMoveAdjacent(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        if (currentPositionX == positionX && Math.abs(currentPositionY - positionY) == 1) return true;
        return currentPositionY == positionY && Math.abs(currentPositionX - positionX) == 1;
    }
}
