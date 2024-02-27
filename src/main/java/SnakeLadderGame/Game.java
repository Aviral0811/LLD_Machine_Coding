package SnakeLadderGame;

import org.apache.commons.lang3.RandomUtils;

import java.util.*;

public class Game {
    private int numberOfSnakes;
    private int numberOfLadders;

    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    private Board board;
    private Dice dice;

    public Game(int numberOfSnakes, int numberOfLadders, int boardsize) {
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfLadders = numberOfLadders;
        players = new ArrayDeque<>();
        snakes = new ArrayList<>(numberOfSnakes);
        ladders = new ArrayList<>(numberOfLadders);
        board = new Board(boardsize);
        dice = new Dice(1, 6, 4);
        initGame();
    }
    public void initGame(){
        HashSet<String> snake_ladder = new HashSet<>();

        for(int i = 0; i < numberOfSnakes; i++) {
            while (true) {
                int snake_head = RandomUtils.nextInt(board.getStart(), board.getSize());
                int snake_tail = RandomUtils.nextInt(board.getStart(), board.getSize());

                if (snake_tail >= snake_head) continue;

                String start_end_pair = String.valueOf(snake_head) + snake_tail;
                if (!snake_ladder.contains(start_end_pair)) {
                    Snake snake = new Snake(snake_head, snake_tail);
                    snakes.add(snake);
                    snake_ladder.add(start_end_pair);
                    break;
                }
            }
        }
        for(int j = 0; j < numberOfLadders; j++) {
            while (true) {
                int ladder_head = RandomUtils.nextInt(board.getStart(), board.getSize());
                int ladder_tail = RandomUtils.nextInt(board.getStart(), board.getSize());

                if (ladder_tail <= ladder_head) continue;

                String start_end_pair = String.valueOf(ladder_head) + ladder_tail;
                if (!snake_ladder.contains(start_end_pair)) {
                    Ladder ladder = new Ladder(ladder_head, ladder_tail);
                    ladders.add(ladder);
                    snake_ladder.add(start_end_pair);
                    break;
                }
            }
        }
    }

    public void addPlayer(Player player){
        players.offer(player);
    }

    public void playGame(){
        while(true){
            Player player = players.poll();
            int val = dice.rollDice();

            int newposition = player.getPosition() + val;

            //if match is about to end and winning player throws dice
            //and gets position beyond the board size
            // let the position of player be same as it was earlier
            if(newposition > board.getEnd()){
                player.setPosition(player.getPosition());
                players.offer(player);
            }else{
                player.setPosition(getNewPosition(newposition));
                if(player.getPosition() == board.getEnd()){
                    player.setWon(true);

                    System.out.println("Player " + player.getName() + " has won!");
                }else{
                    System.out.println("Setting player's " + player.getName() + "new position " + player.getPosition());
                    players.offer(player);
                }
            }
            if(players.size() < 2){
                break;
            }
        }
    }
    public int getNewPosition(int newposition){
        for(Snake snake : snakes){
            if(snake.getHead() == newposition){
                System.out.println("You've been bit by snake");
                return snake.getTail();
            }
        }

        for(Ladder ladder : ladders){
            if(ladder.getStart() == newposition){
                System.out.println("You've crawled the ladder");
                return ladder.getEnd();
            }
        }

        return newposition;
    }
}
