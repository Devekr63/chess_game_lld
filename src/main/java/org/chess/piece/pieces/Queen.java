package org.chess.piece.pieces;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.PieceType;

public class Queen extends Piece {
    public Queen(Color color, int x, int y) {
        super(PieceType.QUEEN, color, x, y);
    }

    @Override
    public boolean canMove(int positionX, int positionY, Color pathColor) {
        int currentPositionX = this.currentPosition[1];
        int currentPositionY = this.currentPosition[0];

        return canMoveDiagonal(positionX, positionY, currentPositionX, currentPositionY)
                || canMoveStraight(positionX, positionY, currentPositionX, currentPositionY);
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color enemyColor, Color pathColor) {
        return !this.color.equals(enemyColor) && canMove(positionX, positionY, pathColor);
    }

    private boolean canMoveDiagonal(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return Math.abs(positionX - currentPositionX) == Math.abs(positionY - currentPositionY);
    }

    private boolean canMoveStraight(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return (positionX == currentPositionX) || (positionY == currentPositionY);
    }
}
