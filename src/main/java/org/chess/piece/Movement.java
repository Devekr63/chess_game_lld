package org.chess.piece;

import org.chess.game.Color;

public interface Movement {
    boolean canMove(int positionX, int positionY, Color pathColor);

    boolean canCapturePiece(int positionX, int positionY, Color color, Color pathColor);
}
