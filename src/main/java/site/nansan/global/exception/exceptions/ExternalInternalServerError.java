package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class ExternalInternalServerError extends EnException {
    public ExternalInternalServerError(ErrorCode errorCode) {
        super(errorCode);
    }
}
