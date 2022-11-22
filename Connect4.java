import java.util.Scanner;
import usantatecla.utils.*;

public class Connect4{
	private Board board;
	private Turn turn;
	private Player[] player;
	private final int NUM_PLAYER = 2;


	public Connect4(){
		this.board = new Board();
		this.turn = new Turn(this.board);
		player = new Player[NUM_PLAYER];
		turn.reset();
	}

	private void playGame() {
		//Error error = player.getPutTokenError(this.board, board.getColumn());
		board.initBoard();
		board.showInterface();
		do {
			this.turn.play();
			//if (error == Error.NULL)
			 	turn.changeColor();
			board.showInterface();
		} while (!this.isConnect4());

		/*else if (isTie())
			Message.TIED_MESSAGE.toString();*/
	}

	/*public boolean isTie(){
		return (board.fullBoard() || player.getCountTokens() == MAX_TOKEN) ? true : false;
	}*/

	private boolean isConnect4() {
		//return this.board.isConnect4(this.turn.getActiveColor());
		return this.board.isConnect4(this.turn.getActiveColor());
	}

	public static void main(String[] args) {
		new Connect4().playGame();
	}
}