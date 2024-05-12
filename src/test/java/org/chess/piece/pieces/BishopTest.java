package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class BishopTest {

    @Test
    public void canMoveOrCapture() {
        Bishop bishop = new Bishop(Color.BLACK, 4, 4, Color.WHITE);

        assertTrue(bishop.canMove(0, 0, Color.WHITE));
        assertTrue(bishop.canMove(7, 1, Color.WHITE));
        assertTrue(bishop.canMove(1, 7, Color.WHITE));
        assertTrue(bishop.canMove(7, 7, Color.WHITE));
        assertFalse(bishop.canMove(7,7, Color.BLACK));
    }
}