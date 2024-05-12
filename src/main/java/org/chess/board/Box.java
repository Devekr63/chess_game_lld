package org.chess.board;

import org.chess.game.Color;
import org.chess.piece.Piece;

public class Box {
    Piece piece;
    Color color;

    public Box(Piece piece, Color color) {
        this.piece = piece;
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
