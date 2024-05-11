package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    public void testCanMove(){
        Pawn pawnBlack = new Pawn(Color.BLACK, 4, 4);
        Pawn pawnWhite = new Pawn(Color.WHITE, 3, 3);

        assertTrue(pawnBlack.canMove(3,4));
        assertTrue(pawnWhite.canMove(4,3));

        assertFalse(pawnBlack.canMove(5,4));
        assertFalse(pawnWhite.canMove(2,3));
        assertFalse(pawnWhite.canMove(5,4));
        assertFalse(pawnWhite.canMove(2,3));
    }



}