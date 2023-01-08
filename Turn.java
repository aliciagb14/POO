
public class Turn {
    private Board board;
    private Color color;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
	private int activePlayer;
	private Victory victory;

    public Turn(Board board, Player[] player, Victory victory){
		this.board = board;
    	this.players = player;
		this.color = Color.R;
		this.victory = victory;
    }

	/**
	 * Nos permitirá el cambio del color para cada turno
	 */

    public void changeColor(){
        if (color == Color.R)
            color = Color.Y;
        else
            color = Color.R;
    }

	/**
	 * Nos permitirá saber el turno según el color
	 * @param color - recibirá el color
	 * @return - nos dira que turno es el que corresponde
	 */

	public char getColorToken(Color color){
		if (color == Color.R)
			return 'R';
		else
			return 'Y';
	}

	/**
	 * Nos permitira saber el nombre de la ficha
	 * @return - nos devolvera el valor del color
	 */

    public String getColor(){
        if (color == Color.R)
            return "RED";
        else
            return "YELLOW";
    }

	/**
	 * Reseteará el turno para cuando se encuentre ganador y se inicie una nueva partida
	 */

	public void reset() {
		for (int i = 0; i < NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(this.board, Color.get(i));
		}
		this.activePlayer = 0;
	}

	/**
	 * Este método llamará al play de jugador para que el jugador indique la columna en la que quiere poner ficha
	 * y nos indicará a qué jugador le toca siempre y cuando no hayamos encontrado ganador
	 * @param game
	 * @param opcion
	 */

	public void play(Connect4 game, int opcion, GestorComandos gestor) {
		this.players[this.activePlayer].play(game, opcion);
		gestor.execute(this.getActiveColor());
		this.changeColor();
		if (!this.victory.isWinner(this.board, this.getActiveColor(), this)){
			this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
		}
	}

	/**
	 * Este método nos indicará cuál es el jugador activo
	 * @return
	 */
	public Color getActiveColor() {
		return this.players[this.activePlayer].getColor();
	}
}
