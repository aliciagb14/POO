import java.util.Scanner;
import usantatecla.utils.*;

public class Connect4{
	private Board board;
	private Turn turn;
	private Player[] player;


	public Connect4(){
		this.board = new Board();
		this.turn = new Turn(this.board);
		player = new Player[Turn.NUMBER_PLAYERS];
		turn.reset();
	}

	private void playGame() {
		//Error error = this.player[turn.getActivePlayer()].getPutTokenError(this.board, board.getColumn());
		board.initBoard();
		board.showInterface();
		do {
			this.turn.play();
			/*if (error == Error.NULL)
			 	turn.changeColor();*/
			board.showInterface();
		} while (!this.isConnect4());
	}

	public boolean isTie(){
		return (board.fullBoard() || this.player[turn.getActivePlayer()].getCountTokens() == Board.MAX_TOKEN);
	}

	private boolean isConnect4() {
		if(!board.isConnect4(this.turn.getActiveColor(), this.player[this.turn.getActivePlayer()])){
			return isTie();
		}
		return false;
	}

	public static void main(String[] args) {
		new Connect4().playGame();
	}
}