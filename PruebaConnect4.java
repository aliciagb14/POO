import java.util.Scanner;
import usantatecla.utils.*;

public class PruebaConnect4 {
    public static void main(String[] args) {

        Board b1 = new Board();
        b1.initBoard();

        Color c1 = Color.R;
        Color c2 = Color.Y;
        Player p1= new Player(b1, c1);
        Player p2 = new Player(b1, c2);

        Turn tRed = new Turn(c1, p1);
        Turn tYellow = new Turn(c2, p2);

        Console console = new Console();
        console.writeln(Message.TITLE.toString());
        console.writeln(Message.HORIZONTAL_LINE.toString());
        b1.showBoard();
        console.writeln(Message.HORIZONTAL_LINE.toString());
        int columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());

        for (int i = 0; i < b1.getDimension() && !b1.fullBoard(); i++) {
            if (tRed.putTurnColor(c1) == "RED"){
                System.out.println("Turn: " + tRed.putTurnColor(c1));
                p1.putToken(tRed, columnInput);
                p1.changeTurn(tRed, columnInput);
            }
            else{
                System.out.println("Turn: " + tYellow.putTurnColor(c2));
                p2.putToken(tYellow, columnInput);
                p2.changeTurn(tYellow, columnInput);
            }
            b1.showBoard();
        }
    }
}
