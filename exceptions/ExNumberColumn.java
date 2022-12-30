package exceptions;

public class ExNumberColumn extends Exception{
    public ExNumberColumn() {
       super("Invalid column!! Values [1-7]");
    }
}
