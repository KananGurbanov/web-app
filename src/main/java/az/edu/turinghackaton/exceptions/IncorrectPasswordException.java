package az.edu.turinghackaton.exceptions;

public class IncorrectPasswordException extends CustomValidationException{
    public IncorrectPasswordException(String code, String message) {
        super(code, message);
    }
}
