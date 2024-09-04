package Exception;

public class CustomException extends Exception{
    
//wrong password
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
//login
class MaximumLoginAttemptsExceededException extends Exception {
    public MaximumLoginAttemptsExceededException(String message ) {
        super(message);
    }
}

//items limit
class MaximumItemsReachedExceededException extends Exception {
    public MaximumItemsReachedExceededException(String message) {
        super(message);
    }
}
//options
class InvalidOptionException extends Exception {
    public InvalidOptionException(String message) {
        super(message);
    }
}
//less money given
class InsufficientAmountException extends Exception {
    public InsufficientAmountException(String message) {
        super(message);
    }
}
}