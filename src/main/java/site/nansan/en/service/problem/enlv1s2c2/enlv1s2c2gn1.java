package site.nansan.en.service.problem.enlv1s2c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.en.service.problem.enlv1s2c1.Common;

@Service
public class enlv1s2c2gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        return Common.make(true);
    }
}
