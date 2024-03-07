package TicTacToe;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){

        //creating 2 players
        players = new ArrayDeque<>();
        PlayingPieceX cross = new PlayingPieceX();
        Player player1 = new Player("Player1", cross);

        PlayingPieceO naught = new PlayingPieceO();
        Player player2 = new Player("Player2", naught);

        players.offer(player1);
        players.offer(player2);

        //initializeBoard
        gameBoard = new Board(3);
    }
    public String startGame(){
        boolean noWinner = true;
        while(noWinner){

            //take out the player whose turn it is and put the player in the list back
            Player playerTurn = players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();

            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            //read the user input

            System.out.println(("Player:" + playerTurn.getName() + " Enter row, column: "));

            Scanner inputScanner = new Scanner(System.in);

            String s = inputScanner.nextLine();
            String[] values = s.split(",");

            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                //player cannot insert piece in this cell
                System.out.println("Incorrect Position Chosen, try again");
                players.offerFirst(playerTurn);
                continue;
            }
            players.offerLast(playerTurn);
        }
        return "Tie";
    }

    public boolean isTheWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i = 0; i < gameBoard.size; i++){
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType){
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
