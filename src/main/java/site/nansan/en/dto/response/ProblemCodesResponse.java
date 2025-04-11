package site.nansan.en.dto.response;

import lombok.Builder;
import lombok.Getter;
import site.nansan.en.dto.dto.ProblemCodesDto;

import java.util.List;

@Getter
@Builder
public class ProblemCodesResponse {

    private List<String> problemCodes;

    public static ProblemCodesResponse from(
            ProblemCodesDto dto
    ) {

        return ProblemCodesResponse.builder()
                .problemCodes(dto.getProblemCodes())
                .build();
    }
}
