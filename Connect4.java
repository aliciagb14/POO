//import designPatterns.Comando;
//import designPatterns.GestorComandos;
//import designPatterns.IComando;
import exceptions.ExColumnFull;
import exceptions.ExNumberColumn;
import usantatecla.utils.*;
//import designPatterns.GestorComandos;

public class Connect4{
	private Board board;
	private Turn turn;
	private Player[] players;
	private Victory victory;
	private Menu menu;
	private GestorComandos gestor;

	public Connect4(){
		this.board = new Board();
		this.victory = new Victory();
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.turn = new Turn(this.board, this.players, victory);
		turn.reset();
		this.menu = new Menu(this, this.board, this.turn.getActiveColor());
		this.gestor = new GestorComandos(turn.getActiveColor(), turn);
	}

	/**
	 * se llaman a distintos métodos que iran desarrollando
	 * la partida mientras que no haya un ganador
	 */

	void playGame() throws ExNumberColumn, ExColumnFull {
		board.initBoard();
		int opcion = menu.chooseMode();
		gestor.getInstance(turn.getActiveColor(), turn);
		do {
			setOption(opcion);
			board.showInterface();
			applyUndoRedo();
			System.out.println("\nTurn " + turn.getActiveColor());
		} while (!this.isConnect4());
	}

	/**
	 * aplicará el patrón undo/redo en cada caso
	 * que el usuario le indique
	 */

	void applyUndoRedo(){
		Color color = turn.getActiveColor();
		String response;
		Console console = new Console();
		response = console.readString(Message.UNDO.toString());
		if (response.equalsIgnoreCase("undo")) {
			gestor.undo();
			board.deleteToken(board.getLastColumn());
			board.showInterface();
			response = console.readString(Message.REDO.toString());
			if (response.equalsIgnoreCase("redo")){
				Color c = gestor.redo();
				if (c != Color.NULL)
					board.putToken(c, board.getLastColumn());
				board.showInterface();
			}
		}
		else if (response.equalsIgnoreCase("redo")){
			Color c = gestor.redo();
			if (c != Color.NULL)
				board.putToken(c, board.getLastColumn());
			board.showInterface();
		}
	}

	/**
	 * servirá como conexion entre los modos de juego y las funciones de cada uno
	 * @param opcion - recibirá el modo de juego
	 * @throws ExNumberColumn
	 * @throws ExColumnFull
	 */

	void setOption(int opcion) throws ExNumberColumn, ExColumnFull {
		if (opcion == 1 || opcion == 3) {
			this.turn.play(this, opcion);
			gestor.execute(turn.getActiveColor());
			this.turn.changeColor();
		}
		else if (opcion == 2) {
			opcion = 1;
			this.turn.play(this, opcion);
			this.turn.changeColor();
			board.showInterface();
			opcion = 2;
			this.turn.play(this, opcion);
			this.turn.changeColor();
		}
		else
			System.exit(0);
	}

	/**
	 * nos permitira saber si hay ganador
	 * @return - retornará un booleano para cada caso
	 * @throws ExNumberColumn
	 * @throws ExColumnFull
	 */

	public boolean isConnect4() throws ExNumberColumn, ExColumnFull {
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

	/**
	 * nos permitirá iniciar la partida
	 * @throws ExNumberColumn
	 * @throws ExColumnFull
	 */

	private void start() throws ExNumberColumn, ExColumnFull {
		this.playGame();
	}

	/**
	 * donde empieza todo, método principal que inicia el programa
	 * @param args
	 * @throws ExNumberColumn
	 * @throws ExColumnFull
	 */

	public static void main(String[] args) throws ExNumberColumn, ExColumnFull {
		new Connect4().start();
	}
}