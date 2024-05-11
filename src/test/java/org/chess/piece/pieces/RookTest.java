package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    public void testStraightMovement(){
        Rook rook = new Rook(Color.BLACK, 4 ,4);

        assertTrue(rook.canMove(4,0));
        assertTrue(rook.canMove(7,4));
        assertTrue(rook.canMove(0,4));
        assertTrue(rook.canMove(4,7));

        assertFalse(rook.canMove(6,0));
        assertFalse(rook.canMove(1,2));
    }

}