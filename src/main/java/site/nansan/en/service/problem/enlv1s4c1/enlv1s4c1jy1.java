package site.nansan.en.service.problem.enlv1s4c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class enlv1s4c1jy1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<Integer> problems = new ArrayList<>();
        int number = CreateRandom.generateRandomInt(4, 9);

        problem.put("number", number);
        for (int p = 1; p < number; p++) {
            problems.add(p);
        }
        problems = CreateRandom.pickRandomNumbers(problems, 3);

        problem.put("ex", problems.get(0));
        answer.put("ex", number - problems.get(0));
        for (int i = 1; i < 3; i++) {

            String keyName = "q" + i;

            problem.put(keyName, problems.get(i));
            answer.put(keyName, number - problems.get(i));
        }

        return ProblemAnswer.from(problem, answer);
    }
}
