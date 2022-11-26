import java.util.Scanner;
import usantatecla.utils.*;
import usantatecla.utils.YesNoDialog;

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
		do {
			Error error = this.players[turn.getActivePlayer()].getPutTokenError(this.board, board.getColumn());
			board.initBoard();
			board.showInterface();
			do {
				System.out.println("Turn " + turn.getActiveColor());
				this.turn.play();
				if (error == Error.NULL)
					this.turn.changeColor();
				board.showInterface();
			} while (!this.isConnect4());
		} while(!board.isWinner(this.turn.getActiveColor(), this.players[this.turn.getActivePlayer()], this.turn));
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

	private boolean isResumedGame() {
		YesNoDialog yesNoDialog = new YesNoDialog();
		yesNoDialog.read(Message.CONTINUE_MESSAGE.toString());
		if (yesNoDialog.isAffirmative()) {
			this.board.initBoard();
			this.turn.reset();
		}
		return yesNoDialog.isAffirmative();
	}

	private void start(){
		do {
			this.playGame();
		} while(this.isResumedGame());
	}

	public static void main(String[] args) {
		new Connect4().start();
	}
}