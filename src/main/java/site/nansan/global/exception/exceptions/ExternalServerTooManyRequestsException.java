package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class ExternalServerTooManyRequestsException extends EnException {
    public ExternalServerTooManyRequestsException(ErrorCode errorCode) {
        super(errorCode);
    }
}

