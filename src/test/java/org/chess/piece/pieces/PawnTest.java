package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnTest {

    @Test
    public void testCanMove() {
        Pawn pawnBlack = new Pawn(Color.BLACK, 4, 4);
        Pawn pawnWhite = new Pawn(Color.WHITE, 3, 3);
        Pawn pw = new Pawn(Color.WHITE, 3, 1);

        assertTrue(pawnBlack.canMove(4, 3, Color.BLACK));
        assertTrue(pawnWhite.canMove(3, 4, Color.BLACK));
        assertTrue(pw.canMove(3, 2, Color.BLACK));

        assertFalse(pawnBlack.canMove(5, 4, Color.BLACK));
        assertFalse(pawnWhite.canMove(2, 3, Color.BLACK));
        assertFalse(pawnWhite.canMove(5, 4, Color.BLACK));
        assertFalse(pawnWhite.canMove(2, 3, Color.BLACK));
    }

    @Test
    public void testCapturePiece() {
        Pawn pawnBlack = new Pawn(Color.BLACK, 4, 4);
        Pawn pawnWhite = new Pawn(Color.WHITE, 3, 3);

        assertTrue(pawnBlack.canCapturePiece(3, 3, Color.WHITE, Color.BLACK));
        assertTrue(pawnBlack.canCapturePiece(2, 2, Color.WHITE, Color.BLACK));

        assertTrue(pawnWhite.canCapturePiece(2, 4, Color.BLACK, Color.BLACK));
        assertTrue(pawnWhite.canCapturePiece(3, 5, Color.BLACK, Color.BLACK));

        assertFalse(pawnBlack.canCapturePiece(3, 5, Color.WHITE, Color.BLACK));
        assertFalse(pawnWhite.canCapturePiece(4, 2, Color.BLACK, Color.BLACK));
        assertFalse(pawnWhite.canCapturePiece(3, 4, Color.BLACK, Color.BLACK));
        assertFalse(pawnBlack.canCapturePiece(4, 3, Color.WHITE, Color.BLACK));
    }
}