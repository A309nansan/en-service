package site.nansan.en.service.problem.enlv1s1c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;

@Service
public class enlv1s1c3jy3 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        final String[] VALUES = {"영", "하나", "둘", "셋", "넷", "다섯", "여섯", "일곱", "여덟", "아홉"};

        return Common.make(VALUES, ImageType.CONCRETE_TYPE);
    }
}
