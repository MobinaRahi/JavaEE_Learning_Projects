package ee.session02.ee2.exception;

public class DuplicateUsernameException extends  Exception {
    public DuplicateUsernameException() {
        super("Duplicate User name !!!");
    }

    public DuplicateUsernameException(String message) {
        super(message);
    }
}
