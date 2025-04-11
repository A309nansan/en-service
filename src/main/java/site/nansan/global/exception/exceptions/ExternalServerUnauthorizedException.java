package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class ExternalServerUnauthorizedException extends EnException {
    public ExternalServerUnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
