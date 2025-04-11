package site.nansan.en.dto.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProblemCodesDto {

    private List<String> problemCodes;

    public static ProblemCodesDto from (
            List<String> problemCodes
    ) {

        return ProblemCodesDto.builder()
                .problemCodes(problemCodes)
                .build();
    }
}
