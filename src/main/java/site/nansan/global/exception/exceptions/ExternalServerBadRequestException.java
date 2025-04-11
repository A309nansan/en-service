package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class ExternalServerBadRequestException extends EnException {
    public ExternalServerBadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
