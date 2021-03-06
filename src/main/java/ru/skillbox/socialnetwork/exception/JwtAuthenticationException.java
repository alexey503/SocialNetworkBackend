package ru.skillbox.socialnetwork.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
@Slf4j
public class JwtAuthenticationException extends AuthenticationException {
    private HttpStatus httpStatus;
   public JwtAuthenticationException(String msg) {
        super(msg);
    }

    public JwtAuthenticationException(String msg, HttpStatus status) {
        super(msg);
        this.httpStatus = status;
        log.error(msg);
    }
}
