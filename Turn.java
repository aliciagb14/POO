import usantatecla.utils.*;

public class Turn {
    private Board board;
    private Color color;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
	private int activePlayer;

    public Turn(Board board, Player[] player){
		this.board = board;
    	this.players = player;
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

	public void reset() {
		for (int i = 0; i < NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(this.board, Color.get(i));
		}
		this.activePlayer = 0;
	}

	public void play(){
		this.players[this.activePlayer].play();
		if (!this.board.isWinner(this.getActiveColor(), players[this.activePlayer], this)){
			this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
		}
	}

	public int getActivePlayer(){ return activePlayer;}

	public void writeWinner(){
		this.players[this.activePlayer].writeWinner();
	}

	public Color getActiveColor() {
		return this.players[this.activePlayer].getColor();
	}
}
