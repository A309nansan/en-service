package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class ExternalServerNotFoundException extends EnException {
    public ExternalServerNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
