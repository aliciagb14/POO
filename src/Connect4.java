import usantatecla.utils.*;

public class Connect4{
	private Board board;
	private Turn turn;
	private Player[] players;
	private Victory victory;
	private Menu menu;

	public Connect4(){
		this.board = new Board();
		this.victory = new Victory();
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.turn = new Turn(this.board, this.players, victory);
		turn.reset();
		this.menu = new Menu(this, this.board, this.turn.getActiveColor());
	}

	void playGame() {
		board.initBoard();
		board.showInterface();
		int opcion = menu.chooseMode();
		do {
			System.out.println("Turn " + turn.getActiveColor());
			setOption(opcion);
			board.showInterface();
		} while (!this.isConnect4());
	}

	void setOption(int opcion){
		if (opcion == 1 || opcion == 3) {
			this.turn.play(this, opcion);
			this.turn.changeColor();
		}
		else if (opcion == 2) {
			opcion = 1;
			this.turn.play(this, opcion);
			this.turn.changeColor();
			opcion = 2;
			this.turn.play(this, opcion);
			this.turn.changeColor();
		}
	}

	public boolean isConnect4() {
		String response;
		Console console = new Console();
		if(!victory.isWinner(this.board, this.turn.getActiveColor(), this.turn)){
			if (this.board.fullBoard())
				Message.TIED_MESSAGE.toString();
		}
		else {
			do {
				response = console.readString(Message.CONTINUE_MESSAGE.toString());
				if (response.equalsIgnoreCase("no"))
					System.exit(0);
				this.start();
			} while(response.equalsIgnoreCase("yes"));
		}
		return false;
	}

	private void start(){
		this.playGame();
	}

	public static void main(String[] args) {
		new Connect4().start();
	}
}