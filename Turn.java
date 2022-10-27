import usantatecla.utils.*;

public class Turn {
    private Board board;
    private Color color;
    /*static final int NUMBER_PLAYERS = 2;
    private Player[] players;*/

    public Turn(Board board, Color color){
        this.board = board;
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
