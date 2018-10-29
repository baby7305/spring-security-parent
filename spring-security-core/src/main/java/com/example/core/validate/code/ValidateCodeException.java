package com.example.core.validate.code;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -1052248605967579469L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
