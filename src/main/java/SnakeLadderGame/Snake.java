package SnakeLadderGame;

import lombok.Getter;
/*
Snake is initialized at the beginning of game
It has to be an all argument constructor
 */
@Getter
public class Snake {
    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
}
