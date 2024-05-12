package org.chess.piece.pieces;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.PieceType;

public class Pawn extends Piece {

    public Pawn(Color color, int x, int y) {
        super(PieceType.PAWN, color, x, y);
    }

    @Override
    public boolean canMove(int positionX, int positionY, Color pathColor) {
        int currenPositionX = this.currentPosition[1];
        int currentPositionY = this.currentPosition[0];

        return canMoveForward(positionX, positionY, currenPositionX, currentPositionY);
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color enemyColor, Color pathColor) {
        int currentPositionX = this.currentPosition[0];
        int currentPositionY = this.currentPosition[1];

        return !this.color.equals(enemyColor) && canMoveDiagonal(positionX, positionY, currentPositionX, currentPositionY);
    }

    private boolean canMoveDiagonal(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return this.color == Color.WHITE && positionY - currentPositionY == 1 && Math.abs(positionX - currentPositionX) == 1
                || this.color == Color.BLACK && positionY - currentPositionY == -1 && Math.abs(positionX - currentPositionX) == 1;
    }

    private boolean canMoveForward(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return this.color == Color.WHITE && positionX == currentPositionX && positionY - currentPositionY == 1
                || this.color == Color.BLACK && positionX == currentPositionX && positionY - currentPositionY == -1;
    }
}
