package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RookTest {

    @Test
    public void testStraightMovement() {
        Rook rook = new Rook(Color.BLACK, 4, 4);

        assertTrue(rook.canMove(4, 0, Color.BLACK));

        assertFalse(rook.canMove(6, 1, Color.BLACK));
        assertFalse(rook.canMove(2, 2, Color.BLACK));
    }

}