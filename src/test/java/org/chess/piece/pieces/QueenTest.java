package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {

    @Test
    public void testDiagonalMovement() {
        Queen queen = new Queen(Color.BLACK, 4, 4);

        //Correct movement
        assertTrue(queen.canMove(7, 1));
        assertTrue(queen.canMove(1, 7));
        assertTrue(queen.canMove(0, 0));
        assertTrue(queen.canMove(7, 7));

        //wrong movement
        assertFalse(queen.canMove(6, 7));
        assertFalse(queen.canMove(7, 6));
    }

    @Test
    public void testStraightMovement() {
        Queen queen = new Queen(Color.BLACK, 4, 4);

        //Correct movement
        assertTrue(queen.canMove(4, 0));
        assertTrue(queen.canMove(4, 7));
        assertTrue(queen.canMove(7, 4));
        assertTrue(queen.canMove(0, 4));

        //Wrong movement
        assertFalse(queen.canMove(2, 5));
        assertFalse(queen.canMove(1, 3));
    }
}