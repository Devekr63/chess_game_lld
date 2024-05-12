package org.chess.board;

import org.chess.game.Color;
import org.chess.piece.Piece;
import org.chess.piece.pieces.*;

public class Board {
    Box[][] board = new Box[8][8];

    public Board() {
        create();
        fillWhites();
        fillBlacks();
    }

    public boolean movePiece(int currentPositionX, int currentPositionY, int newPositionX, int newPositionY) {
        if (!isValidPosition(newPositionX, newPositionY, currentPositionX, currentPositionY)) return false;
        System.out.println(board[currentPositionY][currentPositionX]
                .getPiece().getClass().getSimpleName().charAt(0)
                + "{" + board[currentPositionY][currentPositionX].getPiece().getColor().toString().charAt(0) + "}");

        Piece piece = getPiece(currentPositionX, currentPositionY);
        Color pathColor = getBoxColor(newPositionX, newPositionY);

        if (isPositionEmpty(newPositionX, newPositionY)) {
            if (piece.canMove(newPositionX, newPositionY, pathColor)) {
                System.out.println("Moving Piece to empty position.");
                move(newPositionX, newPositionY, currentPositionX, currentPositionY);
                return true;
            }
            System.out.println("Piece cannot be moved to empty position.");
            return false;
        }

        Piece enemyPiece = getPiece(newPositionX, newPositionY);
        if (piece.canCapturePiece(newPositionX, newPositionY, enemyPiece.getColor(), pathColor)) {
            System.out.println("Piece captured " + getPiece(newPositionX, newPositionY).getClass().getSimpleName());
            move(newPositionX, newPositionY, currentPositionX, currentPositionY);
            return true;
        }
        System.out.println("Invalid Move.");
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

    private Color getBoxColor(int newPositionX, int newPositionY) {
        return board[newPositionY][newPositionX].color;
    }

    private boolean isValidPosition(int posX, int posY, int currX, int currY) {
        int high = 8;
        int low = 0;
        System.out.println(posX + " " + posY + " " + currX + " " + currY);
        return posX < high && posX >= low
                && posY < high && posY >= low
                && currX < high && currX >= low
                && currY < high && currY >= low;
    }

    public Box[][] getBoard() {
        return board;
    }

    private void create() {
        for (int i = 0; i < 8; i++) {
            Box[] lane = board[i];
            if ((i & 1) == 1) {
                for (int j = 0; j < 8; j += 2) {
                    lane[j] = new Box(Color.WHITE);
                    lane[j + 1] = new Box(Color.BLACK);
                }
            } else {
                for (int j = 0; j < 8; j += 2) {
                    lane[j] = new Box(Color.BLACK);
                    lane[j + 1] = new Box(Color.WHITE);
                }
            }
        }
    }

    private void fillWhites() {
        Color white = Color.WHITE;
        Color black = Color.BLACK;
        Box[] lane = board[0];

        lane[0].setPiece(new Rook(white, 0, 0));
        lane[7].setPiece(new Rook(white, 7, 0));
        lane[1].setPiece(new Knight(white, 1, 0));
        lane[6].setPiece(new Knight(white, 6, 0));
        lane[2].setPiece(new Bishop(white, 2, 0, white));
        lane[5].setPiece(new Bishop(white, 5, 0, black));
        lane[4].setPiece(new Queen(white, 4, 0));
        lane[3].setPiece(new King(white, 3, 0));

        lane = board[1];
        for (int i = 0; i < 8; i++) {
            lane[i].setPiece(new Pawn(white, i, 1));
        }
    }

    private void fillBlacks() {
        Color white = Color.WHITE;
        Color black = Color.BLACK;
        Box[] lane = board[7];

        lane[0].setPiece(new Rook(black, 0, 7));
        lane[7].setPiece(new Rook(black, 7, 7));
        lane[1].setPiece(new Knight(black, 1, 7));
        lane[6].setPiece(new Knight(black, 6, 7));
        lane[2].setPiece(new Bishop(black, 2, 7, white));
        lane[5].setPiece(new Bishop(black, 5, 7, black));
        lane[3].setPiece(new Queen(black, 3, 7));
        lane[4].setPiece(new King(black, 4, 7));

        lane = board[6];
        for (int i = 0; i < 8; i++) {
            lane[i].setPiece(new Pawn(black, i, 6));
        }
    }

    public void displayBoard() {
        System.out.print("    1    2    3    4    5    6    7    8 \n");
        int i = 1;
        for (Box[] lane : board) {
            System.out.print(i+"  ");
            for (Box b : lane) {
                if (b.getPiece() != null) {
                    System.out.print(b.getPiece().getClass().getSimpleName().charAt(0) +
                            "'" + b.getPiece().getColor().toString().toLowerCase().charAt(0) + "' ");
                } else {
                    System.out.print(" ".repeat(5));
                }
            }
            i++;
            System.out.println();
        }
    }
}
