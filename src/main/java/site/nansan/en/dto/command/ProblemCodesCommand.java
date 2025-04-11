package site.nansan.en.dto.command;

import lombok.Builder;
import lombok.Getter;
import site.nansan.en.dto.request.ProblemCodesRequest;

@Getter
@Builder
public class ProblemCodesCommand {

    private String chapterCode;

    public static ProblemCodesCommand from(
            ProblemCodesRequest request
    ) {

        return ProblemCodesCommand.builder()
                .chapterCode(request.getChapterCode())
                .build();
    }
}
