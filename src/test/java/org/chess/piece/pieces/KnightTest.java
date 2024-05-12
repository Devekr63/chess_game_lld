package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class KnightTest {

    @Test
    public void testRookMovement() {
        Knight knight = new Knight(Color.BLACK, 4, 4);

        assertTrue(knight.canMove(5, 2, Color.BLACK));
        assertTrue(knight.canMove(6, 3, Color.BLACK));
        assertTrue(knight.canMove(5, 6, Color.BLACK));
        assertTrue(knight.canCapturePiece(6, 5, Color.WHITE, Color.BLACK));
        assertTrue(knight.canMove(3, 2, Color.BLACK));
        assertTrue(knight.canCapturePiece(2, 3, Color.WHITE, Color.BLACK));
        assertTrue(knight.canCapturePiece(3, 6, Color.WHITE, Color.BLACK));
        assertTrue(knight.canMove(2, 5, Color.BLACK));
    }

}