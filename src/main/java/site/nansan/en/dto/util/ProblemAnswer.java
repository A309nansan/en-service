package site.nansan.en.dto.util;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class ProblemAnswer {

    private Map<String, Object> problem;

    private Map<String, Object> answer;

    public static ProblemAnswer from(
            Map<String, Object> problem,
            Map<String, Object> answer
    ) {

        return ProblemAnswer.builder()
                .problem(problem)
                .answer(answer)
                .build();
    }
}
