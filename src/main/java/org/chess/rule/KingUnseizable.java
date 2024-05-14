package org.chess.rule;

public class KingUnseizable implements Rule{
    @Override
    public void error() {
        System.out.println("King can never be Captured in the game. You have to checkmate the King.");
    }
}
