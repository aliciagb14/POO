//package designPatterns;

public class Comando implements IComando {
    private Comando tokenPlay;
    public <Turn> Comando(Turn tokenPlay){
        this.tokenPlay = (Comando) tokenPlay;
    }
    public void execute() {
        tokenPlay.undo();
    }
    public void undo() {
        tokenPlay.execute();
    }

    public void redo() {
        tokenPlay.redo();
    }

    public String getName() {
        return "Pattern applied";
    }

}
