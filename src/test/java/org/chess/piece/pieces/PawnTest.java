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

        assertTrue(pawnBlack.canMove(4, 3));
        assertTrue(pawnWhite.canMove(3, 4));

        assertFalse(pawnBlack.canMove(5, 4));
        assertFalse(pawnWhite.canMove(2, 3));
        assertFalse(pawnWhite.canMove(5, 4));
        assertFalse(pawnWhite.canMove(2, 3));
    }

    @Test
    public void testCapturePiece() {
        Pawn pawnBlack = new Pawn(Color.BLACK, 4, 4);
        Pawn pawnWhite = new Pawn(Color.WHITE, 3, 3);

        assertTrue(pawnBlack.canCapturePiece(3, 3, Color.WHITE));
        assertTrue(pawnBlack.canCapturePiece(5, 3, Color.WHITE));

        assertTrue(pawnWhite.canCapturePiece(2, 4, Color.BLACK));
        assertTrue(pawnWhite.canCapturePiece(4, 4, Color.BLACK));

        assertFalse(pawnBlack.canCapturePiece(3, 5, Color.WHITE));
        assertFalse(pawnWhite.canCapturePiece(4, 2, Color.BLACK));
        assertFalse(pawnWhite.canCapturePiece(3, 4, Color.BLACK));
        assertFalse(pawnBlack.canCapturePiece(4, 3, Color.WHITE));
    }

}