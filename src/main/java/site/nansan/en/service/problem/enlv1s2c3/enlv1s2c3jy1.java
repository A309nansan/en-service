package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.*;

@Service
public class enlv1s2c3jy1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();
        List<Integer> startNumbers = CreateRandom.pickRandomNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 3);

        for (int p = 1; p <= 3; p++) {

            int[] array = makeArray(startNumbers.get(p - 1));
            int blankIndex = CreateRandom.generateRandomInt(1, 3);
            String keyName = "p" + p;

            answer.put(keyName, array);
            array[blankIndex] = 0;
            problem.put(keyName, array);
        }

        return ProblemAnswer.from(problem, answer);
    }

    private int[] makeArray(int sn) {

        return new int[]{sn, sn + 1, sn + 2, sn + 3, sn + 4};
    }
}
