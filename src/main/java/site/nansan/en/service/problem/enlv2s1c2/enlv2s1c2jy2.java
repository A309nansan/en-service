package site.nansan.en.service.problem.enlv2s1c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.HashMap;
import java.util.Map;

@Service
public class enlv2s1c2jy2 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int value = CreateRandom.generateRandomInt(11, 19);
        int left = value-1;
        int right = value+1;

        problem.put("value", value);
        problem.put("left", left);
        problem.put("right", right);

        answer.put("value", value-1);
        return ProblemAnswer.from(problem, answer);
    }
}
