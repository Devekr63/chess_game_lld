package org.chess.board;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.pieces.King;
import org.chess.piece.pieces.Pawn;
import org.chess.piece.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void testMovePieceToEmptyLocation() {
        Board b = new Board();
        Piece king = new King(Color.BLACK, 4, 4);
        assertTrue(b.movePiece(3, 1, 3, 2));
    }

    @Test
    public void captureAPiece() {
        Board b = new Board();
        Piece king = new King(Color.BLACK, 4, 4);

        b.board[4][4] = new Box(king, Color.WHITE);
        b.board[5][4] = new Box(new Pawn(Color.WHITE, 4, 5), Color.BLACK);

        assertTrue(b.movePiece(4, 4, 4, 5));
        assertEquals(b.board[5][4].getPiece(), king);
        assertNull(b.board[4][4].getPiece());
    }

    @Test
    public void doNotCaptureSameColorPiece() {
        Board b = new Board();
        Piece king = new King(Color.BLACK, 4, 4);
        Piece pawn = new Pawn(Color.BLACK, 4, 5);

        b.board[4][4] = new Box(king, Color.WHITE);
        b.board[5][4] = new Box(pawn, Color.BLACK);

        assertFalse(b.movePiece(4, 4, 4, 5));
        assertEquals(b.board[4][4].getPiece(), king);
        assertEquals(b.board[5][4].getPiece(), pawn);
    }

    @Test
    public void isPositionBoundedToBoard() {
        Board b = new Board();
        Piece king = new King(Color.BLACK, 4, 4);

        b.board[4][4] = new Box(king, Color.WHITE);
        b.board[5][5] = new Box(null, Color.WHITE);

        assertFalse(b.movePiece(4, 4, 8, 8));
        assertFalse(b.movePiece(4, 4, -1, -1));

    }

    @Test
    public void kingNeverDies(){
        Board b = new Board();
        Piece queen = new Queen(Color.BLACK, 4 , 4);
        Piece enemyKing = new King(Color.WHITE,  5, 5);

        b.board[4][4] = new Box(queen, Color.BLACK);
        b.board[5][5] = new Box(enemyKing, Color.WHITE);

        assertFalse(b.movePiece(4,4,5,5));
        assertEquals(b.board[4][4].getPiece(), queen);
        assertEquals(b.board[5][5].getPiece(), enemyKing);
    }
}