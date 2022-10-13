import usantatecla.utils.*;

import java.util.Scanner;

public class Player {
    private Color color;
    private Board board;
    private final int MAX_TOKEN = 42;
    private Turn turn;
    public Player(){}

    public Player(Color color, Board board){
        this.color = color;
        this.board = board;
    }

    public void putToken(int columnInput){
       if (board.isEmpty(columnInput)){

       }
    }

    public Turn getTurn(){
      return turn;
    }
}
