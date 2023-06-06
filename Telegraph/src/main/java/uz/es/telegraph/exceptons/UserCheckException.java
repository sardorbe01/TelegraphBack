package uz.es.telegraph.exceptons;

public class UserCheckException extends RuntimeException {
    public UserCheckException(String message) {
        super(message);
    }
}
