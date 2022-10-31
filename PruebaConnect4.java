import java.util.Scanner;
import usantatecla.utils.*;

public class PruebaConnect4 {
    public static void main(String[] args) {
        Board b1 = new Board();
        b1.initBoard();
        Player[] players;
        players = new Player[2];

        Color c1 = Color.R;
        Color c2 = Color.Y;
        players[0] = new Player(b1, c1);
        players[1] = new Player(b1, c2);

        Turn tRed = new Turn(b1, c1);
        Turn tYellow = new Turn(b1, c2);

        Console console = new Console();
        console.writeln(Message.TITLE.toString());
        console.writeln(Message.HORIZONTAL_LINE.toString());
        b1.showBoard();
        console.writeln(Message.HORIZONTAL_LINE.toString());
        int columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());

        for (int i = 0; i < b1.getDimension() && !b1.fullBoard(); i++) {
            if (tRed.putTurnColor(c1) == "RED"){
                System.out.println("Turn: " + tRed.putTurnColor(c1));
                players[0].putToken(columnInput);
                tRed.changeTurn(columnInput);
            }
            else{
                System.out.println("Turn: " + tYellow.putTurnColor(c2));
                players[1].putToken(columnInput);
                tYellow.changeTurn(columnInput);
            }
            b1.showBoard();
        }
    }
}
