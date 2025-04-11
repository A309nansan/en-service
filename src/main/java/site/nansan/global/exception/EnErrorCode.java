package site.nansan.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Custom Error Code Naming Rule: <Service Name>_<Http Status Code>_<Index>
 * ex. User, Category, En, M ...
 * Http Status Code 설명
 * https://www.notion.so/Custom-Error-Code-HttpStatus-1c01696ab58480b8a937c095198c2103?pvs=4
 */

@Getter
@AllArgsConstructor
public enum EnErrorCode implements ErrorCode {

    // 4XX: Client Error
    VALIDATION_FAILED(HttpStatus.OK, "CLIENT_4XX_1", "잘못된 입력입니다. 올바르게 입력해주세요."),
    INCORRECT_PROBLEM_CODE(HttpStatus.OK, "CLIENT_400_1", "잘못된 문제 유형입니다."),

    // 5XX: Server Error
    INTERNAL_SERVER_ERROR(HttpStatus.OK, "SERVER_5XX_1", "서버가 혼잡합니다. 다시 시도해 주세요."),
    ;

    private final HttpStatus httpStatus;

    private final String errorCode;

    private final String errorMessage;
}
