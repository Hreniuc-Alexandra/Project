package com.lupascu.db.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TokenNotValidException extends GlobalException {
    public TokenNotValidException() {
    }

    public TokenNotValidException(String s) {
        super(s);
    }

    public TokenNotValidException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TokenNotValidException(Throwable throwable) {
        super(throwable);
    }

    public TokenNotValidException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
