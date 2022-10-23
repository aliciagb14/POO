import java.util.Scanner;
import usantatecla.utils.*;

public class PruebaConnect4 {
    public static void main(String[] args) {
        Board b1 = new Board();
        b1.initBoard();
        Player p1 = new Player();
        Player p2 = new Player();
        Color c1 = p1.getColor(Color.get(0));
        Color c2 = p2.getColor(Color.get(1));
        Color cNull = p2.getColor(Color.get(3));
        Turn tRed = new Turn(b1, c1);
        Turn tYellow = new Turn(b1, c2);
        System.out.println("El color del j1 es " + c1 + " y el de j2 " + c2);

        Console console = new Console();
        console.writeln(Message.TITLE.toString());
        console.writeln(Message.HORIZONTAL_LINE.toString());
        b1.showBoard();
        console.writeln(Message.HORIZONTAL_LINE.toString());
        System.out.println("Turn: " + tRed.putTurnColor(c1));
      //  System.out.println("Turn j2 es " + tYellow.putTurnColor(c2));
       // System.out.println("Turn j1 es " + tYellow.putTurnColor(cNull));
        int columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
        p1.putToken(columnInput);
        b1.showBoard();
    }
}
