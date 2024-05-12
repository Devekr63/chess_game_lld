package org.chess.piece.pieces;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.PieceType;

public class Queen extends Piece {
    public Queen(Color color, int x, int y) {
        super(PieceType.QUEEN, color, x, y);
    }

    @Override
    public boolean canMove(int positionX, int positionY) {
        int currentPositionX = this.currentPosition[1];
        int currentPositionY = this.currentPosition[0];

        return canMoveDiagonal(positionX, positionY, currentPositionX, currentPositionY)
                || canMoveStraight(positionX, positionY, currentPositionX, currentPositionY);
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color color) {
        return !this.color.equals(color) && canMove(positionX, positionY);
    }

    private boolean canMoveDiagonal(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return Math.abs(positionX - currentPositionX) == Math.abs(positionY - currentPositionY);
    }

    private boolean canMoveStraight(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return (positionX == currentPositionX) || (positionY == currentPositionY);
    }
}
