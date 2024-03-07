package TicTacToe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private PlayingPiece playingPiece;

    public Player(String name, PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }
}
