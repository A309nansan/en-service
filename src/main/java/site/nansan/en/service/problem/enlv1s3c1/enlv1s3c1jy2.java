package site.nansan.en.service.problem.enlv1s3c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class enlv1s3c1jy2 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int problemNumber = CreateRandom.generateRandomInt(2, 8);

        problem.put("q1", problemNumber);
        answer.put("a1", List.of(problemNumber - 1, problemNumber + 1));


        return ProblemAnswer.from(problem, answer);
    }
}
