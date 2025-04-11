package site.nansan.en.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import site.nansan.en.dto.command.SolvedProblemCommand;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@Document(collection = "solved_problem")
public class SolvedProblem {

    @Id
    private String id;

    @Field("user_id")
    private Long userId;

    @Field("child_id")
    private Long childId;

    @Field("problem_code")
    private String problemCode;

    @Field("date_time")
    private LocalDateTime dateTime;

    @Field("solving_time")
    private Integer solvingTime;

    @Field("is_corrected")
    private Boolean isCorrected;

    @Field("problem")
    private Map<String, Object> problem;

    @Field("answer")
    private Map<String, Object> answer;

    @Field("input")
    private Map<String, Object> input;

    public static SolvedProblem from(
            SolvedProblemCommand command
    ) {

        return SolvedProblem.builder()
                .userId(command.getUserId())
                .childId(command.getChildId())
                .problemCode(command.getProblemCode())
                .dateTime(command.getDateTime())
                .solvingTime(command.getSolvingTime())
                .isCorrected(command.getIsCorrected())
                .problem(command.getProblem())
                .answer(command.getAnswer())
                .input(command.getInput())
                .build();
    }
}
