package org.chess.board;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.pieces.King;
import org.chess.piece.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void testMovePieceToEmptyLocation(){
        Board b = new Board();
        Piece king = new King(Color.BLACK, 4, 4);

        b.board[4][4] = new Box(king, Color.WHITE);
        b.board[5][5] = new Box(null, Color.WHITE);

        assertTrue(b.movePiece(4,4,5,5));
    }

    @Test
    public void captureAPiece(){
        Board b = new Board();
        Piece king = new King(Color.BLACK, 4, 4);

        b.board[4][4] = new Box(king, Color.WHITE);
        b.board[5][4] = new Box(new Pawn(Color.WHITE, 4,5), Color.BLACK);

        assertTrue(b.movePiece(4,4, 4,5));
    }

    @Test
    public void doNotCaptureSmallColorPiece(){
        Board b = new Board();
        Piece king = new King(Color.BLACK, 4, 4);

        b.board[4][4] = new Box(king, Color.WHITE);
        b.board[5][4] = new Box(new Pawn(Color.BLACK, 4,5), Color.BLACK);

        assertFalse(b.movePiece(4,4, 4,5));
    }
}