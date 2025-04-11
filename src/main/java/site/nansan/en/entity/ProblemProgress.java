package site.nansan.en.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProblemProgress {

    Integer currentProblemNumber;

    Integer totalProblemCount;

    public static ProblemProgress from(
            Integer currentProblemNumber,
            Integer totalProblemCount
    ) {

        return ProblemProgress.builder()
                .currentProblemNumber(currentProblemNumber)
                .totalProblemCount(totalProblemCount)
                .build();
    }
}
