package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    public void testDiagonalMovement(){
        King king = new King(Color.BLACK, 4, 4);

        assertTrue(king.canMove(3,3));
        assertTrue(king.canMove(3,5));
        assertTrue(king.canMove(5,3));
        assertTrue(king.canMove(5,5));

        assertFalse(king.canMove(5,6));

    }

    @Test
    public void testStraightMovement(){
        King king = new King(Color.BLACK, 4, 4);

        assertTrue(king.canMove(3,4));
        assertTrue(king.canMove(4,3));
        assertTrue(king.canMove(4,5));
        assertTrue(king.canMove(5,4));

        assertFalse(king.canMove(6,6));

    }
}