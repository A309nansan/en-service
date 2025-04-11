package site.nansan.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingConfig {

    /**
     * setIncludeQueryString(boolean) : 쿼리 스트링 포함 여부
     * setIncludePayload(boolean)     : 요청 바디 포함 여부
     * setMaxPayloadLength(int)       : 로그에 출력할 최대 바디 길이
     * setIncludeHeaders(boolean)     : 헤더 포함 여부
     * setAfterMessagePrefix(String)  : 로그 메시지 앞에 붙일 텍스트
     */
    @Bean
    public CommonsRequestLoggingFilter logFilter() {

        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();

        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("[원본 JSON 요청]: ");

        return filter;
    }
}
