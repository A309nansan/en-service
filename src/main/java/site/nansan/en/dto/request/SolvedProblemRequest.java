package site.nansan.en.dto.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolvedProblemRequest {

    private Long userId;

    private Long childId;

    private String problemCode;

    private LocalDateTime dateTime;

    private Integer solvingTime;

    private Boolean isCorrected;

    private Map<String, Object> problem;

    private Map<String, Object> answer;

    private Map<String, Object> input;
}
