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
        assertTrue(queen.canMove(7, 1, Color.BLACK));
        assertTrue(queen.canMove(1, 7, Color.BLACK));
        assertTrue(queen.canMove(0, 6, Color.BLACK));
        assertTrue(queen.canMove(7, 6, Color.BLACK));

        //wrong movement
        assertFalse(queen.canMove(5, 5, Color.BLACK));
        assertFalse(queen.canMove(6, 4, Color.BLACK));
    }

    @Test
    public void testStraightMovement() {
        Queen queen = new Queen(Color.BLACK, 4, 4);

        //Correct movement
        assertTrue(queen.canMove(4, 0, Color.BLACK));
        assertTrue(queen.canMove(4, 7, Color.BLACK));
        assertTrue(queen.canMove(7, 4, Color.BLACK));
        assertTrue(queen.canMove(0, 4, Color.BLACK));

        //Wrong movement
        assertFalse(queen.canMove(2, 5, Color.BLACK));
        assertFalse(queen.canMove(2, 5, Color.BLACK));
    }
}