package org.chess.piece.pieces;

import org.chess.game.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    public void testRookMovement(){
        Rook rook = new Rook(Color.BLACK, 4, 4);

        assertTrue(rook.canMove(5,2));
        assertTrue(rook.canMove(6,3));
        assertTrue(rook.canMove(5,6));
        assertTrue(rook.canCapturePiece(6,5));
        assertTrue(rook.canMove(3,2));
        assertTrue(rook.canCapturePiece(2,3));
        assertTrue(rook.canCapturePiece(3,6));
        assertTrue(rook.canMove(2,5));
    }

}