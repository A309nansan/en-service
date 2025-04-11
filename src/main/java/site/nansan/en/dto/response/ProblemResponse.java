package site.nansan.en.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import site.nansan.en.dto.dto.ProblemDto;

import java.util.Map;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemResponse {

    private String problemCode;

    private String nextProblemCode;

    private Integer currentProblemNumber;

    private Integer totalProblemCount;

    private Map<String, Object> problem;

    private Map<String, Object> answer;

    public static ProblemResponse from(
            ProblemDto dto
    ) {

        return ProblemResponse.builder()
                .problemCode(dto.getProblemCode())
                .nextProblemCode(dto.getNextProblemCode())
                .currentProblemNumber(dto.getCurrentProblemNumber())
                .totalProblemCount(dto.getTotalProblemCount())
                .problem(dto.getProblem())
                .answer(dto.getAnswer())
                .build();
    }
}
