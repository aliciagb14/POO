import java.util.Scanner;
import usantatecla.utils.*;

public class Connect4{
	private Board board;
	private Turn turn;
	private Player[] players;


	public Connect4(){
		this.board = new Board();
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.turn = new Turn(this.board, this.players);
		turn.reset();
	}

	private void playGame() {
		Error error = this.players[turn.getActivePlayer()].getPutTokenError(this.board, board.getColumn());
		board.initBoard();
		board.showInterface();
		do {
			this.turn.play();
			if (error == Error.NULL)
				this.turn.changeColor();
			board.showInterface();
		} while (!this.isConnect4());
	}

	public boolean isTie(){
		Message.TIED_MESSAGE.toString();
		return (board.fullBoard());
	}

	private boolean isConnect4() {
		if(!board.isWinner(this.turn.getActiveColor(), this.players[this.turn.getActivePlayer()], this.turn)){
			return isTie();
		}
		return false;
	}

	public static void main(String[] args) {
		new Connect4().playGame();
	}
}