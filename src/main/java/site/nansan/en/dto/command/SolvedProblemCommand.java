package site.nansan.en.dto.command;

import lombok.Builder;
import lombok.Getter;
import site.nansan.en.dto.request.SolvedProblemRequest;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class SolvedProblemCommand {

    private Long userId;

    private Long childId;

    private String problemCode;

    private LocalDateTime dateTime;

    private Integer solvingTime;

    private Boolean isCorrected;

    private Map<String, Object> problem;

    private Map<String, Object> answer;

    private Map<String, Object> input;

    public static SolvedProblemCommand from (
            SolvedProblemRequest request
    ) {

        return SolvedProblemCommand.builder()
                .userId(request.getUserId())
                .childId(request.getChildId())
                .problemCode(request.getProblemCode())
                .dateTime(request.getDateTime())
                .solvingTime(request.getSolvingTime())
                .isCorrected(request.getIsCorrected())
                .problem(request.getProblem())
                .answer(request.getAnswer())
                .input(request.getInput())
                .build();
    }
}
