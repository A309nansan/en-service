package site.nansan.global.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

    private static final ObjectMapper prettyMapper = new ObjectMapper()
            .findAndRegisterModules() // LocalDateTime 직렬화 지원
            .enable(SerializationFeature.INDENT_OUTPUT); // pretty-print

    public static void logJson(Object obj, String prefix) {

        // 원래는 throw Runtime Exception
        if (obj == null) {
            return;
        }

        // 비즈니스 흐름을 막지 않도록 로컬에서 조용히 처리하기 위한 try-catch문
        try {

            String json = prettyMapper.writeValueAsString(obj);
            log.debug("{}: {}", prefix, json);
        } catch (JsonProcessingException e) {

            log.error("JSON 변환 실패", e);
        }
    }
}
