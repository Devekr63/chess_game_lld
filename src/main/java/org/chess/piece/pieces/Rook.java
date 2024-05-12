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
        boolean canMove = canMoveStraight(positionX, positionY, this.getPositionX(), this.getPositionY());
        if (canMove) jumpToNewPosition(positionX, positionY);
        return canMove;
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color enemyColor, Color pathColor) {
        return !this.color.equals(enemyColor) && canMove(positionX, positionY, pathColor);
    }

    private boolean canMoveStraight(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        return positionY == currentPositionY && Math.abs(positionX - currentPositionX) > 0
                || positionX == currentPositionX && Math.abs(positionY - currentPositionY) > 0;
    }
}
