package org.chess.player;

import org.chess.game.Color;

public class Player {
    Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
