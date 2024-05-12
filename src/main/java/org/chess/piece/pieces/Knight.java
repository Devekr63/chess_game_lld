package org.chess.piece.pieces;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.PieceType;

public class Knight extends Piece {

    public Knight(Color color, int x, int y) {
        super(PieceType.KNIGHT, color, x, y);
    }

    @Override
    public boolean canMove(int positionX, int positionY, Color pathColor) {
        return canMoveLShaped(positionX, positionY, this.currentPosition[1], this.currentPosition[0]);
    }

    @Override
    public boolean canCapturePiece(int positionX, int positionY, Color enemyColor, Color pathColor) {
        return !this.color.equals(enemyColor) && canMoveLShaped(positionX, positionY, this.currentPosition[1], this.currentPosition[0]);
    }

    private boolean canMoveLShaped(int positionX, int positionY, int currentPositionX, int currentPositionY) {
        int yMove = Math.abs(positionY - currentPositionY);
        int xMove = Math.abs(positionX - currentPositionX);

        return (yMove == 1 && xMove == 2) || (yMove == 2 && xMove == 1);
    }
}
