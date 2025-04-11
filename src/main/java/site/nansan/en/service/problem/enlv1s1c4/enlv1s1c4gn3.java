package site.nansan.en.service.problem.enlv1s1c4;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.en.service.problem.enlv1s1c3.Common;

@Service
public class enlv1s1c4gn3 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        final String[] VALUES = {"영", "하나", "둘", "셋", "넷", "다섯", "여섯", "일곱", "여덟", "아홉"};

        return Common.make(VALUES, ImageType.SEMI_CONCRETE_TYPE);
    }
}
