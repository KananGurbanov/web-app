package az.edu.turinghackaton.handler;


import az.edu.turinghackaton.exceptions.EmailExistException;
import az.edu.turinghackaton.exceptions.IncorrectPasswordException;
import az.edu.turinghackaton.exceptions.UserNotFoundException;
import az.edu.turinghackaton.model.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    public static final String ERROR_LOG = "Error: ";

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<ErrorResponse> handleException(EmailExistException ex,
                                                         WebRequest request) {
        log.error(ERROR_LOG, ex);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getCode(), ex.getMessage(), getPath(request));

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(UserNotFoundException ex,
                                                         WebRequest request) {
        log.error(ERROR_LOG, ex);

        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getCode(), ex.getMessage(), getPath(request));
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ErrorResponse> handleException(IncorrectPasswordException ex,
                                                         WebRequest request) {
        log.error(ERROR_LOG, ex);

        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getCode(), ex.getMessage(), getPath(request));
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status,
                                                             String errorCode,
                                                             String errorDetail,
                                                             String path) {
        return ResponseEntity.status(status)
                .body(new ErrorResponse(
                        status.value(),
                        errorCode,
                        errorDetail,
                        path,
                        LocalDateTime.now()));
    }

    private String getPath(WebRequest webRequest) {
        return ((ServletWebRequest) webRequest).getRequest().getRequestURI();
    }
}
