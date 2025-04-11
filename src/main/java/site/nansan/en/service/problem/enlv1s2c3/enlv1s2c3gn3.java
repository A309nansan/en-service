package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class enlv1s2c3gn3 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int mid = CreateRandom.generateRandomInt(3, 7);
        boolean isLeft = CreateRandom.generateRandomInt(0, 1) == 0;

        problem.put("list", List.of(mid - 2, mid, mid + 2));
        problem.put("number", isLeft ? mid - 1 : mid + 1);
        answer.put("left", isLeft);
        answer.put("right", !isLeft);

        return ProblemAnswer.from(problem, answer);
    }
}
