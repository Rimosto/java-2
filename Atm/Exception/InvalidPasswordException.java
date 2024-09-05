package Exception;

public class InvalidPasswordException extends RuntimeException {
    //wrong password
    public InvalidPasswordException(String message) {
        super(message);
    }
}

