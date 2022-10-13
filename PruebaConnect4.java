import java.util.Scanner;
import usantatecla.utils.*;

public class PruebaConnect4 {
    public static void main(String[] args) {
        Board b1 = new Board();
        Player p1 = new Player();
        Message.TITLE.toString();
        Message.HORIZONTAL_LINE.toString();
        b1.initBoard();
        b1.showBoard();
        Message.HORIZONTAL_LINE.toString();
        Console console = new Console();
        int columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
        p1.putToken(columnInput);
        System.out.println("Turn: " + p1.getTurn());
    }
}
