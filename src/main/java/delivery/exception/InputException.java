package delivery.exception;

/**
 * @author nilver
 * @version 1.0.0
 * @since 1.0.0
 */
public class InputException extends RuntimeException {

    public InputException(String message,Throwable cause){
        super(message,cause);
    }
}
