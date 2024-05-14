package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {

    @Test
    public void testMovement() {
        King king = new King(Color.BLACK, 4, 4);

        assertTrue(king.canMove(3, 3, Color.BLACK));
        assertTrue(king.canMove(3, 4, Color.BLACK));
        assertTrue(king.canMove(2, 4, Color.BLACK));
        assertTrue(king.canMove(1, 5, Color.BLACK));

        assertFalse(king.canMove(5, 6, Color.BLACK));
    }
}