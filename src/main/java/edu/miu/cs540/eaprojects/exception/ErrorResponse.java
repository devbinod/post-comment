package edu.miu.cs540.eaprojects.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int code;
    private String status;
    private String message;
    private String details;

    public ErrorResponse(HttpStatus httpStatus, String message, String description) {
        timestamp=LocalDateTime.now();
        this.code=httpStatus.value();
        this.status= httpStatus.toString();
        this.message=message;
        this.details=description;
    }
}
