package SnakeLadderGame;

import org.apache.commons.lang3.RandomUtils;

public class Dice {
    /*
    A dice has a minimum value say 1
    It has a maximum value say 6
    Current value here represents the Value of dice after rolling dice.
     */
    private int minvalue;
    private int maxvalue;
    private int currentvalue;

    public Dice(int minvalue, int maxvalue, int currentvalue) {
        this.minvalue = minvalue;
        this.maxvalue = maxvalue;
        this.currentvalue = currentvalue;
    }

    public int getMinvalue() {
        return minvalue;
    }

    public int getMaxvalue() {
        return maxvalue;
    }

    public int getCurrentvalue() {
        return currentvalue;
    }

    // A method which will give the value of rolled dice
    public int rollDice(){
        return RandomUtils.nextInt(minvalue, maxvalue + 1);
    }
}
