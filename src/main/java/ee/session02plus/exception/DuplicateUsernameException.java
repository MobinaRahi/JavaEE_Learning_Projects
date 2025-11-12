package ee.session02plus.exception;

public class DuplicateUsernameException extends  Exception {
    public DuplicateUsernameException() {
        super("Duplicate User name !!!");
    }

    public DuplicateUsernameException(String message) {
        super(message);
    }
}
