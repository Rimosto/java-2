package Exception;

//items limit
class MaximumItemsReachedExceededException extends RuntimeException {
    public MaximumItemsReachedExceededException(String message) {
        super(message);
    }
}