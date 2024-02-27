package SnakeLadderGame;

import lombok.Getter;
/*
Board is an immutable object and nothing will change in it
Hence used getters
 */
@Getter
public class Board {
    private int size; // size of board let us assume 100 blocks
    private int start;
    private int end;

    public Board(int size) {
        this.size = size;
        this.start = 1; // starting block will always be one
        this.end = start + size - 1; // end will be 1+99 = 100
    }
}
