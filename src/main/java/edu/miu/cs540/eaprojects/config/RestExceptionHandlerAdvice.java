package edu.miu.cs540.eaprojects.config;

import edu.miu.cs540.eaprojects.exception.CommentNotFoundException;
import edu.miu.cs540.eaprojects.exception.ErrorResponse;
import edu.miu.cs540.eaprojects.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandlerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> postNotFound(PostNotFoundException ex, WebRequest request) {

        return new ResponseEntity<ErrorResponse>
                (new ErrorResponse(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage(),
                        request.getDescription(false)
                ), HttpStatus.NOT_FOUND
                );
    }


    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<ErrorResponse> commentNotFound(CommentNotFoundException ex, WebRequest request) {

        return new ResponseEntity<ErrorResponse>
                (new ErrorResponse(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage(),
                        request.getDescription(false)
                ), HttpStatus.NOT_FOUND
                );
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> internalServerException(Exception exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                request.getDescription(false)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
