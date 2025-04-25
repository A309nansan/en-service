package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class enlv1s2c3gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<Integer> up = CreateRandom.pickRandomNumbers(9, 0, 4);
        List<Integer> down = CreateRandom.pickRandomNumbers(1, 0, 4);

        for (int i = 0; i < 4; i++) {

            String keyName1 = "p" + (i + 1);
            String keyName2 = "p" + (i + 5);

            problem.put(keyName1, new int[]{up.get(i), 1});
            answer.put(keyName1, up.get(i) + 1);

            problem.put(keyName2, new int[]{down.get(i), 1});
            answer.put(keyName2, down.get(i) - 1);
        }

        return ProblemAnswer.from(problem, answer);
    }
}
