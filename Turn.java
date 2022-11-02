import usantatecla.utils.*;

public class Turn {
    private Board board;
    private Color color;
    static final int NUMBER_PLAYERS = 2;
    private Player player;
    //private Player[] players;

    public Turn(Color color, Player player){
        this.player = player;
      /*  this.players = new Player[NUMBER_PLAYERS];
        this.players[0] = player1;
        this.players[1] = player2;*/
        this.color = color;
    }

    public String putTurnColor(Color color){
        if (!color.isNull()){
            if (color == color.get(0))
                return "RED";
            else
                return "YELLOW";
        }
        return "ERROR";
    }

}
