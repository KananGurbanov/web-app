package az.edu.turinghackaton.exceptions;

public class EmailExistException extends CustomValidationException {
    public EmailExistException(String code, String message) {
        super(code, message);
    }
}
