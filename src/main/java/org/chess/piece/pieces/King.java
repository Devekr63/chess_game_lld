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
        boolean canMove = canMoveDiagonal(positionX, positionY, this.getPositionX(), this.getPositionY())
                || canMoveAdjacent(positionX, positionY, this.getPositionX(), this.getPositionY());
        if (canMove) jumpToNewPosition(positionX, positionY);
        return canMove;
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color enemyColor, Color pathColor) {
        return !this.color.equals(enemyColor) && canMove(positionX, positionY, pathColor);
    }

    private boolean canMoveDiagonal(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return Math.abs(currentPositionX - positionX) == 1 && Math.abs(currentPositionY - positionY) == 1;
    }

    private boolean canMoveAdjacent(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        if (currentPositionX == positionX && Math.abs(currentPositionY - positionY) == 1) return true;
        return currentPositionY == positionY && Math.abs(currentPositionX - positionX) == 1;
    }
}
