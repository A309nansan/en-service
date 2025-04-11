package site.nansan.en.service.problem.enlv1s4c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.HashMap;
import java.util.Map;

@Service
public class enlv1s4c2jy1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int left = CreateRandom.generateRandomInt(1, 5);
        int right = CreateRandom.generateRandomInt(1, 5);
        int value = left + right;

        problem.put("left", left);
        problem.put("right", right);
        answer.put("value", value);

        return ProblemAnswer.from(problem, answer);
    }
}
