import usantatecla.utils.*;

/**
 * Clase que nos permitirá controlar los mensajes que mostraremos por pantalla
 * para que el usuario vaya desarrollando el juego siguiendo las indicaciones y sobretodo
 * para saber si ha ganado la partida
 */

public enum Message {
    TITLE("\n---- CONNECT 4 ----"),
    HORIZONTAL_LINE("---------------"),
    VERTICAL_LINE("|"),
    MODE("Select the mode of the game: "),
    BASIC_MODE("Basic mode "),
    TRAINING_MODE("Training mode "),
    DEMO_MODE("Demo mode "),
    ENTER_COLUMN_TO_PUT("Enter a column to drop a token:"),
    TIED_MESSAGE("TIED!!"),
    PLAYER_WIN("#player player: You win!!! :-)"),
    CONTINUE_MESSAGE("Do you want to continue? (yes/no):"),
    UNDO("Do you want make undo/no? (undo/no): "),
    REDO("Do you want make redo/no? (redo/no): ");

    private String message;

    private Message(String message){
        this.message = message;
    }

	public void writeln(String player) {
		assert this == Message.PLAYER_WIN;
		
		Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
	}

    @Override
    public String toString() {
        return message;
    }
}
