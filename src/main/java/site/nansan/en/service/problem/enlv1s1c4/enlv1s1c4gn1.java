package site.nansan.en.service.problem.enlv1s1c4;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.en.service.problem.enlv1s1c3.Common;

@Service
public class enlv1s1c4gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        final String[] VALUES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        return Common.make(VALUES, ImageType.SEMI_CONCRETE_TYPE);
    }
}
