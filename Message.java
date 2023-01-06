import usantatecla.utils.*;

public enum Message {
    TITLE("---- CONNECT 4 ----"),
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
    UNDO("Do you want make undo/redo? (undo/no): "),
    REDO("Do you want make undo/redo? (redo/no): ");

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
