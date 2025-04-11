package site.nansan.global.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EnException extends RuntimeException {

    private final ErrorCode errorCode;
}
