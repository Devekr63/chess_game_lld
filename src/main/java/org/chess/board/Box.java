package org.chess.board;

import org.chess.game.Color;
import org.chess.piece.Piece;

public class Box {
    Piece piece;
    Color color;

    public Box(Color color) {
        this.color = color;
    }

    public Box(Piece piece, Color boxColor) {
        this.piece = piece;
        this.color = boxColor;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
