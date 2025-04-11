package site.nansan.global.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    HttpStatus getHttpStatus();

    String getErrorCode();

    String getErrorMessage();
}
