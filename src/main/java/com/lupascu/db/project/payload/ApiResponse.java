package com.lupascu.db.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String error;
    private T result;

    public ApiResponse(T result) {
        this.result = result;
        this.error = null;
    }
}
