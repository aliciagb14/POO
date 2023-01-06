import usantatecla.utils.Console;

public class Menu {
    private Connect4 game;
    private Board board;
    private Color color;
    public Menu(Connect4 game, Board board, Color color){
        this.board = board;
        this.color = color;
        this.game = game;
    }

    public int chooseMode(){
        Console console = new Console();
        MachinePlayer machine = new MachinePlayer(board, color);
        boolean out = false;
        int opcion;

        console.writeln("1-" + Message.BASIC_MODE.toString());
        console.writeln("2-" + Message.TRAINING_MODE.toString());
        console.writeln("3-" +Message.DEMO_MODE.toString());
        console.writeln("4-Salir");
        opcion = console.readInt(Message.MODE.toString());
        switch(opcion){
                case 1:
                    System.out.println(Message.BASIC_MODE.toString() + "select");
                    break;
                case 2:
                    System.out.println(Message.TRAINING_MODE.toString() + "select");
                    break;
                case 3:
                    System.out.println(Message.DEMO_MODE.toString() + "select");
                    break;
                case 4:
                    break;
            }
        return opcion;
    }
}

