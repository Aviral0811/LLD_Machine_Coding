package SnakeLadderGame;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;// name doesn't change that's why no setter and only getter method for name
    @Setter
    private int position; // position is mutable, hence setter also needed
    @Setter
    private boolean won; // mutable, hence setter needed

    public Player(String name) {
        this.name = name;
        this.position = 0; // initial position is Zero
        this.won = false; // player has not won, initial value will be false;
    }

}
