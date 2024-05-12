package org.chess.board;

import org.chess.game.Color;
import org.chess.piece.Piece;

public class Board {
    Box[][] board = new Box[8][8];

    public boolean movePiece(int currentPositionX, int currentPositionY, int newPositionX, int newPositionY) {
        if(!isValidPosition(newPositionX, newPositionY, currentPositionX, currentPositionY)) return false;

        Piece piece = getPiece(currentPositionX, currentPositionY);
        Color pathColor = getBoxColor(newPositionX, newPositionY);

        if (isPositionEmpty(newPositionX, newPositionY)) {
            if (piece.canMove(newPositionX, newPositionY, pathColor)) {
                move(newPositionX, newPositionY, currentPositionX, currentPositionY);
                return true;
            }
            return false;
        }

        Piece enemyPiece = getPiece(newPositionX, newPositionY);
        if(piece.canCapturePiece(newPositionX, newPositionY, enemyPiece.getColor(), pathColor)){
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

    private Color getBoxColor(int newPositionX, int newPositionY){
        return board[newPositionY][newPositionX].color;
    }

    private boolean isValidPosition(int posX, int posY, int currX, int currY){
        int high = 8;
        int low = 0;
        return posX <= high && posX >= low
                && posY <= high && posY >= low
                && currX <= high && currX >= low
                && currY <= high && currY >= low;
    }
}
