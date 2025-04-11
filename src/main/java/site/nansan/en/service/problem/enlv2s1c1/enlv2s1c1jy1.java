package site.nansan.en.service.problem.enlv2s1c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.HashMap;
import java.util.Map;

@Service
public class enlv2s1c1jy1 extends ProblemService {
    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int first = CreateRandom.generateRandomInt(0, 10);
        int second = 10-first;

        problem.put("first", first);
        problem.put("second", second);
        answer.put("answer", "");

        return ProblemAnswer.from(problem, answer);
    }
}
