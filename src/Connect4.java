import java.util.Scanner;
import usantatecla.utils.*;
import usantatecla.utils.YesNoDialog;

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
			this.turn.play(opcion);
			this.turn.changeColor();
			board.showInterface();
		} while (!this.isConnect4());
	}

	private boolean isConnect4() {
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