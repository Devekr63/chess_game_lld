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
        boolean canMove = canMoveForward(positionX, positionY, this.getPositionX(), this.getPositionY());
        if (canMove) {
            jumpToNewPosition(positionX, positionY);
        }
        return canMove;
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color enemyColor, Color pathColor) {
        boolean canCapture = !this.color.equals(enemyColor) && canMoveDiagonal(positionX, positionY, currentPosition[1], currentPosition[0]);
        if (canCapture) {
            jumpToNewPosition(positionX, positionY);
        }
        return canCapture;
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
