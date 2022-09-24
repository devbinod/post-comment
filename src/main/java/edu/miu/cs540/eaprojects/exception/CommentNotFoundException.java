package edu.miu.cs540.eaprojects.exception;


public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(String message) {
        super(message);
    }
}
