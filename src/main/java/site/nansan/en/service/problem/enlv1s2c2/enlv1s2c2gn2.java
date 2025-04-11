package site.nansan.en.service.problem.enlv1s2c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.*;

@Service
public class enlv1s2c2gn2 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        for (int i = 1; i <= 5; i++) {

            int[] answerArray = createAnswerArray(i);
            int[] problemArray = createProblemArray(i, CreateRandom.generateRandomInt(1, 3));

            problem.put("p" + i, problemArray);
            answer.put("p" + i, answerArray);
        }

        return ProblemAnswer.from(problem, answer);
    }

    private int[] createAnswerArray(int start) {

        return new int[]{start + 4, start + 3, start + 2, start + 1, start};
    }

    private int[] createProblemArray(int start, int fixed) {

        int[] problemArray = new int[]{start + 4, 0, 0, 0, start};

        problemArray[fixed] = start + 4 - fixed;
        return problemArray;
    }
}
