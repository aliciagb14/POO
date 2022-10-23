import java.util.Scanner;
import usantatecla.utils.*;

public class PruebaConnect4 {
    public static void main(String[] args) {
        Board b1 = new Board();
        Player p1 = new Player("RED", b1);
        Player p2 = new Player("YELLOW", b1);
        Console console = new Console();
        console.writeln(Message.TITLE.toString());
        console.writeln(Message.HORIZONTAL_LINE.toString());
        b1.initBoard();
        b1.showBoard();
        console.writeln(Message.HORIZONTAL_LINE.toString());
        int columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
        p1.putToken(columnInput);
    }
}
