package com.lupascu.db.project.api;

import com.lupascu.db.project.exceptions.GlobalException;
import com.lupascu.db.project.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public final ResponseEntity<ApiResponse<String>> handleChronosException(GlobalException globalException) {
        globalException.printStackTrace();
        return handleChronosException(globalException.getMessage(), globalException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        ex.printStackTrace();
        return handleExceptionGeneral(ex);
    }

    private ResponseEntity<ApiResponse<String>> handleChronosException(String message, HttpStatus status) {
        return handleExceptionInternal(message, status);
    }

    private ResponseEntity<ApiResponse<String>> handleExceptionGeneral(Exception ex) {
        return new ResponseEntity<>(new ApiResponse<>("An unhandled exception of type: " + ex.getClass().getName() + " was thrown.", null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiResponse<String>> handleExceptionInternal(String message, HttpStatus status) {
        return new ResponseEntity<>(new ApiResponse<>(message, null), status);
    }
}
