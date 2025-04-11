package site.nansan.en.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemCodesRequest {

    @NotNull(message = "Chapter Code는 NULL을 허용하지 않습니다.")
    private String chapterCode;
}
