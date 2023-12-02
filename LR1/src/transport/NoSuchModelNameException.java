package transport;

public class NoSuchModelNameException extends Exception{
    public NoSuchModelNameException(String name){
        super("Не существует модели с именем '" + name + "'.");
    }
}
