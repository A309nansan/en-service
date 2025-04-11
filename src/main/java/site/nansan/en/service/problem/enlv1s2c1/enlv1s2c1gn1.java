package site.nansan.en.service.problem.enlv1s2c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

@Service
public class enlv1s2c1gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        return Common.make(false);
    }
}
