package site.nansan.global.exception.exceptions;

import site.nansan.global.exception.ErrorCode;
import site.nansan.global.exception.EnException;

public class InvalidDataException extends EnException {
    public InvalidDataException(ErrorCode errorCode) {
        super(errorCode);
    }
}
