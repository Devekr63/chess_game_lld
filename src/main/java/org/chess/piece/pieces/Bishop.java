package org.chess.piece.pieces;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.PieceType;

public class Bishop extends Piece {

    private final Color pathColor;

    public Bishop(Color color, int x, int y, Color pathColor) {
        super(PieceType.BISHOP, color, x, y);
        this.pathColor = pathColor;
    }

    @Override
    public boolean canMove(int positionX, int positionY, Color pathColor) {
        boolean canMove = this.pathColor.equals(pathColor)
                && canMoveDiagonal(positionX, positionY, this.currentPosition[1], this.currentPosition[0]);
        if (canMove) jumpToNewPosition(positionX, positionY);
        return canMove;
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color enemyColor, Color pathColor) {
        return !this.color.equals(enemyColor)
                && canMove(positionX, positionY, pathColor);
    }

    private boolean canMoveDiagonal(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return Math.abs(positionX - currentPositionX) == Math.abs(positionY - currentPositionY);
    }
}
