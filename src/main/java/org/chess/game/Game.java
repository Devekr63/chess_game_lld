package org.chess.game;

import org.chess.board.Board;
import org.chess.player.Player;

import java.util.Scanner;

public class Game {
    public void start() {
        Board chess = new Board();

        Player playerBlack = new Player(Color.BLACK);
        Player playerWhite = new Player(Color.WHITE);

        Player turn = playerWhite;
        Player next = playerBlack;

        Scanner sc = new Scanner(System.in);
        while (true) {
            chess.displayBoard();
            System.out.println("Player " + turn.getColor() + " turn.");
            String s = sc.nextLine();
            String[] inputs = s.split(" ");

            boolean outcome = chess.movePiece(Integer.parseInt(inputs[0])-1,
                    Integer.parseInt(inputs[1])-1,
                    Integer.parseInt(inputs[2])-1,
                    Integer.parseInt(inputs[3])-1);
            if (!outcome) {
                System.out.println("Invalid input, Player " + turn.getColor() + " turn.");
            } else {
                Player temp = turn;
                turn = next;
                next = temp;
                System.out.println("Player " + turn.getColor() + " turn.");
            }
        }
    }
}
