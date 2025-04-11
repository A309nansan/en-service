package site.nansan.global.exception;

import jakarta.annotation.Nullable;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EnException.class)
    public ResponseEntity<Object> handleEnException(EnException e) {

        log.warn("⚠️ EnException occurred: {}, message = {}", e.getErrorCode(), e.getMessage(), e);
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    /**
     * [@Valid] [@RequestBody] 유효성 검증 실패 처리
     * ex. @NotBlank(message = "Custom Message Content")
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e,
            HttpHeaders httpHeaders,
            HttpStatusCode httpStatusCode,
            WebRequest webRequest
    ) {

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        log.warn("[@Valid] [@RequestBody] 유효성 검증 실패: {}", errors);
        return ErrorResponse.toResponseEntity(EnErrorCode.VALIDATION_FAILED, errors);
    }

    /**
     * [@RequestParam], [@PathVariable] 유효성 검증 실패 처리
     * ex. @NotBlank(message = "Custom Message Content")
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {

        Map<String, String> errors = new HashMap<>();

        e.getConstraintViolations().forEach(violation -> {
                    errors.put(violation.getPropertyPath().toString(), violation.getMessage());
                });

        log.warn("[@RequestParam], [@PathVariable] 유효성 검증 실패: {}", errors);
        return ErrorResponse.toResponseEntity(EnErrorCode.VALIDATION_FAILED, errors);
    }

    /**
     * Spring이 자동으로 처리하는 특정 Exception의 응답을 처리하는 Method
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception e,
            @Nullable Object body,
            HttpHeaders httpHeaders,
            HttpStatusCode httpStatusCode,
            WebRequest webRequest
    ) {

        log.error("Spring 내부 예외 처리: {}, 상태 = {}", e.getClass().getSimpleName(), httpStatusCode, e);
        return ErrorResponse.toResponseEntity((HttpStatus) httpStatusCode);
    }

    /**
     * 명시되지 않은 모든 Exception 처리를 하는 FallBack Method
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {

        log.error("처리되지 않은 예외 발생", e);
        return ErrorResponse.toResponseEntity(EnErrorCode.INTERNAL_SERVER_ERROR);
    }
}
