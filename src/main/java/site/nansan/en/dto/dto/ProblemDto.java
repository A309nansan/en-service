package site.nansan.en.dto.dto;

import lombok.Builder;
import lombok.Getter;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ProblemProgress;

import java.util.Map;

@Getter
@Builder
public class ProblemDto {

    private String problemCode;

    private String nextProblemCode;

    private Integer currentProblemNumber;

    private Integer totalProblemCount;

    private Map<String, Object> problem;

    private Map<String, Object> answer;

    public static ProblemDto from(
            String problemCode,
            String nextProblemCode,
            ProblemProgress pp,
            ProblemAnswer pa
    ) {

        return ProblemDto.builder()
                .problemCode(problemCode)
                .nextProblemCode(nextProblemCode)
                .currentProblemNumber(pp.getCurrentProblemNumber())
                .totalProblemCount(pp.getTotalProblemCount())
                .problem(pa.getProblem())
                .answer(pa.getAnswer())
                .build();
    }
}
