package org.chess.piece;

public interface Movement {
    boolean canMove(int positionX, int positionY);
    boolean canCapturePiece(int positionX, int positionY);
}
