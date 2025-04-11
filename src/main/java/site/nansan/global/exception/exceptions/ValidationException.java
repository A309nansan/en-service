package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class ValidationException extends EnException {
    public ValidationException(ErrorCode errorCode){super(errorCode);}
}
