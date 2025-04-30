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

            String keyName = "p" + p;
            int startNumber = startNumbers.get(p - 1);
            int blankIndex = CreateRandom.generateRandomInt(1, 3);

            int[] answerArray = makeAnswerArray(startNumber);
            int[] problemArray = makeProblemArray(startNumber, blankIndex);

            answer.put(keyName, answerArray);
            problem.put(keyName, problemArray);
        }

        return ProblemAnswer.from(problem, answer);
    }

    private int[] makeAnswerArray(int sn) {

        return new int[]{sn, sn + 1, sn + 2, sn + 3, sn + 4};
    }

    private int[] makeProblemArray(int sn, int idx) {

        int[] problemArray = makeAnswerArray(sn);

        problemArray[idx] = 0;
        return problemArray;
    }
}
