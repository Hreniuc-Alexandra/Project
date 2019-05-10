package com.lupascu.db.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PurchaseException extends GlobalException {
    public PurchaseException() {
    }

    public PurchaseException(String s) {
        super(s);
    }

    public PurchaseException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PurchaseException(Throwable throwable) {
        super(throwable);
    }

    public PurchaseException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
