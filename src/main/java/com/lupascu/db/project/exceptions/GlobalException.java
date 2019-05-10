package com.lupascu.db.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalException extends Exception {

    public GlobalException() {
    }

    public GlobalException(String s) {
        super(s);
    }

    public GlobalException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GlobalException(Throwable throwable) {
        super(throwable);
    }

    public GlobalException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

    public HttpStatus getHttpStatus() {
        ResponseStatus annotation = this.getClass().getAnnotation(ResponseStatus.class);
        if (annotation != null) {
            return annotation.value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
