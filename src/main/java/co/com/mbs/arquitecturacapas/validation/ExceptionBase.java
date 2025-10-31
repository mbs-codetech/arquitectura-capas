package co.com.mbs.arquitecturacapas.validation;

public class ExceptionBase extends RuntimeException  {
    private final String message;

    public ExceptionBase(String message) {
        super(message);
        this.message = message;
    }
}
