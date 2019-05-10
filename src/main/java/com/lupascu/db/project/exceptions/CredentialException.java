package com.lupascu.db.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CredentialException extends GlobalException {
    public CredentialException() {
    }

    public CredentialException(String s) {
        super(s);
    }

    public CredentialException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CredentialException(Throwable throwable) {
        super(throwable);
    }

    public CredentialException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
