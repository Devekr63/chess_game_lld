package org.chess.board;

import org.chess.piece.Piece;

public class Board {
    Box[][] board = new Box[8][8];

    public boolean movePiece(int currentPositionX, int currentPositionY, int newPositionX, int newPositionY) {
        Piece piece = getPiece(currentPositionX, currentPositionY);

        if (isPositionEmpty(newPositionX, newPositionY)) {
            if (piece.canMove(newPositionX, newPositionY)) {
                move(newPositionX, newPositionY, currentPositionX, currentPositionY);
                return true;
            }
            return false;
        }

        Piece enemyPiece = getPiece(newPositionX, newPositionY);
        if(piece.canCapturePiece(newPositionX, newPositionY, enemyPiece.getColor())){
            System.out.println("Piece captured "+ getPiece(newPositionX, newPositionY).getClass().getSimpleName());
            move(newPositionX, newPositionY, currentPositionX, currentPositionY);
            return true;
        }
        return false;
    }

    private boolean isPositionEmpty(int newPositionX, int newPositionY) {
        return getPiece(newPositionX, newPositionY) == null;
    }

    private void move(int x, int y, int currX, int currY) {
        Piece p = getPiece(currX, currY);
        board[currY][currX].setPiece(null);
        board[y][x].setPiece(p);
    }

    private Piece getPiece(int newPositionX, int newPositionY) {
        return board[newPositionY][newPositionX].getPiece();
    }
}
