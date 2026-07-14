package exceptions;

public class EventServiceException extends RuntimeException {
    public EventServiceException(String message) {
        super(message);
    }
}
