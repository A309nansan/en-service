package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class ExternalServerForbiddenException extends EnException {
    public ExternalServerForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
