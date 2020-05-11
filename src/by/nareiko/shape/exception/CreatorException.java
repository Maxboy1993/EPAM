package by.nareiko.shape.exception;

public class CreatorException extends Exception {

    private static final long serialVersionUID = 1L;

    public CreatorException() {
        super();
    }

    public CreatorException(String message) {
        super(message);
    }

    public CreatorException(Exception e) {
        super(e);
    }

    public CreatorException(String message, Exception e) {
        super(message, e);
    }
}
