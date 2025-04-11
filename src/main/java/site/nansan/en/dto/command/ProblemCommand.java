package site.nansan.en.dto.command;

import lombok.Builder;
import lombok.Getter;
import site.nansan.en.dto.request.ProblemRequest;

@Getter
@Builder
public class ProblemCommand {

    private String problemCode;

    public static ProblemCommand from(
            ProblemRequest request
    ) {

        return ProblemCommand.builder()
                .problemCode(request.getProblemCode())
                .build();
    }
}
