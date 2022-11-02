import java.util.Scanner;
import usantatecla.utils.*;

public class PruebaConnect4 {
    public static void main(String[] args) {

        Board b1 = new Board();
        b1.initBoard();

        Color c1 = Color.R;
        Color c2 = Color.Y;

        Turn turn = new Turn();

        Player p1= new Player(b1, c1);
        Player p2 = new Player(b1, c2);

        Console console = new Console();
        b1.showInterface();
        int columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());

        Error error = Error.NULL;
      for (int i = 0; i < b1.getDimension(); i++) {
          if (!b1.fullBoard()) {
              if (turn.getColor().equals("RED")) { //tRed.putTurnColor(c1) == "RED"
                  System.out.println("Turn: " + turn.getColor());
                  if (p1.getPutTokenError(b1, columnInput)  == Error.FAILED_NUMBER_COLUMN_INSERTION) {
                      columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
                  } else
                      error = Error.NULL;
                  p1.putToken(columnInput);
              } else {
                  System.out.println("Turn: " + turn.getColor());
                  if (p2.getPutTokenError(b1, columnInput) == Error.FAILED_NUMBER_COLUMN_INSERTION) {
                      columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
                  } else
                      error = Error.NULL;
                  p2.putToken(columnInput);
              }
              if (error == Error.NULL)
                turn.changeColor();
              b1.showInterface();
              columnInput = console.readInt(Message.ENTER_COLUMN_TO_PUT.toString());
          }
      }
    }
}
