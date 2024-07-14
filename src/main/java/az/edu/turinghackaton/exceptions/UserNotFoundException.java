package az.edu.turinghackaton.exceptions;

public class UserNotFoundException extends CustomValidationException{
    public UserNotFoundException(String code, String message) {
        super(code, message);
    }
}
