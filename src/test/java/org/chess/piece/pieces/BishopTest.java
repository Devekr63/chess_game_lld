package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BishopTest {

    @Test
    public void canMoveOrCapture() {
        Bishop bishop = new Bishop(Color.BLACK, 4, 4, Color.WHITE);

        assertTrue(bishop.canMove(0, 0, Color.WHITE));
        assertTrue(bishop.canMove(2, 2, Color.WHITE));
        assertTrue(bishop.canMove(0, 4, Color.WHITE));
        assertTrue(bishop.canMove(3, 7, Color.WHITE));
        assertFalse(bishop.canMove(7, 3, Color.BLACK));
    }
}