
import usantatecla.utils.*;


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
		this.menu = new Menu(this, this.board, Color.R); //this.turn.getActiveColor()
		this.gestor = new GestorComandos(Color.R, turn);
	}

	/**
	 * Nos permite elegir el modo de juego y nos dará la opción de aplicar el patrón undo/redo.
	 * El UserPlayer será el que podrá deshacer o rehacer un movimiento.
	 * Siempre indicará a que jugador le toca poner ficha en ese momento
	 */

	void playGame() {
		board.initBoard();
		int opcion = menu.chooseMode();
		do {
			setOption(opcion);
			board.showInterface();
			System.out.println("Turn " + turn.getActiveColor());
			if (opcion == 1)
				applyUndoRedo();
		} while (!this.isConnect4());
	}

	/**
	 * Aplicará el patrón undo/redo. Primero será necesario que el usuario haga un undo
	 * que permitirá al jugador deshacer la acción y el redo se podrá hacer inmediatamente después si el
	 * jugador quisiera rehacer el movimiento.
	 */

	void applyUndoRedo(){
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
	}

	/**
	 * Servirá como conexion entre los modos de juego y las funciones de cada uno
	 * @param opcion - recibirá el modo de juego
	 */

	void setOption(int opcion)  {
		if (opcion == 1 || opcion == 3) {
			this.turn.play(this, opcion, gestor);
			this.turn.changeColor();
		}
		else if (opcion == 2) {
			opcion = 1;
			this.turn.play(this, opcion, gestor);
			this.turn.changeColor();
			board.showInterface();
			applyUndoRedo();
			opcion = 2;
			this.turn.play(this, opcion, gestor);
			this.turn.changeColor();
		}
		else
			System.exit(0);
	}

	/**
	 *  Comprobaremos si se ha encontrado un ganador, si es el caso,
	 *  dejaremos que el usuario decida si quiere seguir jugando o no.
	 *  Si no se ha encontrado ganador, comprobará si el tablero está lleno
	 *  y en ese caso, se producirá un Empate que será notificado con un mensaje.
	 * @return - retornará un booleano para cada caso
	 */

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

	/**
	 * Nos permitirá iniciar la partida
	 */

	private void start() {
		this.playGame();
	}

	/**
	 * Donde empieza todo, método principal que inicia el programa
	 * @param args
	 */

	public static void main(String[] args) {
		new Connect4().start();
	}
}