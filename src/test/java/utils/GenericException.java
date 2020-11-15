package lib;

public class GenericException extends Exception {

    public GenericException(String message) {
        super("SNSW EXCEPTION: " + message);
    }
}