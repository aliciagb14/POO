import usantatecla.utils.*;

public enum Message {
    TITLE("--- CONNECT 4 ---"),
    HORIZONTAL_LINE("-------------------------"),
    VERTICAL_LINE("|"),
    ENTER_COLUMN_TO_PUT("Enter a column to drop a token:"),
    TIED_MESSAGE("TIED!!"),
    PLAYER_WIN("#player player: You win!!! :-)"),
    CONTINUE_MESSAGE("Do you want to continue? (y/n):");

    private String message;

    private Message(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
