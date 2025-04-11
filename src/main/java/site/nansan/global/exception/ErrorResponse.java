package site.nansan.global.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String errorCode;

    private String errorMessage;

    private Map<String, String> errors;

    public static ResponseEntity<Object> toResponseEntity(ErrorCode errorCode) {

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                .errorCode(errorCode.getErrorCode())
                                .errorMessage(errorCode.getErrorMessage())
                                .build()
                );
    }

    public static ResponseEntity<Object> toResponseEntity(HttpStatus httpStatus) {

        return ResponseEntity
                .status(httpStatus)
                .body(
                        ErrorResponse.builder()
                                .errorCode(String.format("EN_%s_%s", httpStatus.value(), httpStatus.name()))
                                .errorMessage(httpStatus.getReasonPhrase())
                                .build()
                );
    }

    public static ResponseEntity<Object> toResponseEntity(ErrorCode errorCode, Map<String, String> errors) {

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(
                        ErrorResponse.builder()
                                .errorCode(errorCode.getErrorCode())
                                .errorMessage(errorCode.getErrorMessage())
                                .errors(errors)
                                .build()
                );
    }
}
