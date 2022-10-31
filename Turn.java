import usantatecla.utils.*;

public class Turn {
    private Board board;
    private Color color;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;

    public Turn(Board board, Color color){
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
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

    public void changeTurn(int column){
        boolean encontrado = false;
        int fichasMAX = board.getDimension();
        do {
            if (fichasMAX % 2 == 0) {
                this.players[0].getColor(Color.get(0));
                players[0].putToken(column);
            }
            else {
                this.players[1].getColor(Color.get(1));
                players[1].putToken(column);
            }
            encontrado = true;
            fichasMAX--;
        } while (encontrado == false);
    }
}
