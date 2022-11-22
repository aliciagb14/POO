import usantatecla.utils.*;

public class Turn {
    private Board board;
    private Color color;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
	private int activePlayer;

    public Turn(Board board){
		this.board = board;
    	this.players = new Player[Turn.NUMBER_PLAYERS];
        this.color = Color.R;
		this.reset();
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
		if (!this.board.isConnect4(this.getActiveColor())){
			this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
		}
	}

	public void writeWinner(){
		this.players[this.activePlayer].writeWinner();
	}

	public Color getActiveColor() {
		return this.players[this.activePlayer].getColor();
	}
}
