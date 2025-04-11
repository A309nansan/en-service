package site.nansan.global.aop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import site.nansan.global.util.LogUtil;

@Aspect
@Component
@Slf4j
public class RequestLoggingAspect {

    @Around("execution(* site.nansan..controller..*(..))")
    public Object logRequestAndResponse(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        // 요청 파라미터 로그
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {

            // DTO만 로그 (String, Multipart 제외)
            if (arg != null && !(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)) {

                LogUtil.logJson(arg, "[요청 DTO] " + className + "." + methodName);
            }
        }

        // 메서드 실행
        Object result = joinPoint.proceed();
        // 응답 로그
        LogUtil.logJson(result, "[응답 DTO] " + className + "." + methodName);

        return result;
    }
}
