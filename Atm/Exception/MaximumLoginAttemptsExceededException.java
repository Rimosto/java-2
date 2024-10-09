package Exception;

public class MaximumLoginAttemptsExceededException extends RuntimeException {
    //login
    public MaximumLoginAttemptsExceededException(String message ) {
        super(message);
    }
}

