package site.nansan.en.service.problem.enlv1s1c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;

@Service
public class enlv1s1c3jy2 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        final String[] VALUES = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};

        return Common.make(VALUES, ImageType.CONCRETE_TYPE);
    }
}
