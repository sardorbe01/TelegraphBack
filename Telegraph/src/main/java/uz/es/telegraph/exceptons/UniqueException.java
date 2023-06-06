package uz.es.telegraph.exceptons;

public class UniqueException extends RuntimeException{
    public UniqueException(String message) {
        super(message);
    }
}
