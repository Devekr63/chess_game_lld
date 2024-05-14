package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class KnightTest {

    @Test
    public void testRookMovement() {
        Knight knight = new Knight(Color.BLACK, 4, 4);

        assertTrue(knight.canMove(5, 2, Color.BLACK));
        assertTrue(knight.canMove(6, 4, Color.BLACK));
        assertTrue(knight.canMove(4, 5, Color.BLACK));
        assertTrue(knight.canCapturePiece(2, 4, Color.WHITE, Color.BLACK));
        assertTrue(knight.canMove(1, 2, Color.BLACK));
        assertTrue(knight.canCapturePiece(0, 4, Color.WHITE, Color.BLACK));
        assertTrue(knight.canCapturePiece(1, 6, Color.WHITE, Color.BLACK));
        assertTrue(knight.canCapturePiece(3, 5, Color.WHITE, Color.WHITE));
        assertTrue(knight.canMove(4, 3, Color.BLACK));
    }

}