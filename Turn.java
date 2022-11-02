import usantatecla.utils.*;

public class Turn {
    private Board board;
    private Color color;
    static final int NUMBER_PLAYERS = 2;
    //private Player[] players;

    public Turn(){
        //this.player = player;
      /*  this.players = new Player[NUMBER_PLAYERS];
        this.players[0] = player1;
        this.players[1] = player2;*/
        this.color = Color.R;
    }

    public void changeColor(){
        if (color == Color.R)
            color = Color.Y;
        else
            color = Color.R;
    }

    public String getColor(){
        if (color == Color.R)
            return "RED";
        else
            return "YELLOW";
    }

}
