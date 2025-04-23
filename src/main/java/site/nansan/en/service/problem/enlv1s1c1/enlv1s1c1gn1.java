package site.nansan.en.service.problem.enlv1s1c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

import java.util.HashMap;
import java.util.Map;

@Service
public class enlv1s1c1gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        problem.put("test", "test");
        answer.put("test", "test");

        return ProblemAnswer.from(problem, answer);
    }
}
