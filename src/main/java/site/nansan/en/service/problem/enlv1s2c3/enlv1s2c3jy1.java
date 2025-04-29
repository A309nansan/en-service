package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class enlv1s2c3jy1 extends ProblemService {

    private final Random random = new Random();

    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int[][] answers = new int[3][];

        problem.put("p1", generateProblemAndSaveAnswer(answers, 0));
        problem.put("p2", generateProblemAndSaveAnswer(answers, 1));
        problem.put("p3", generateProblemAndSaveAnswer(answers, 2));

        answer.put("p1", answers[0]);
        answer.put("p2", answers[1]);
        answer.put("p3", answers[2]);

        return ProblemAnswer.from(problem, answer)  ;
    }

    private int[] generateProblemAndSaveAnswer(int[][] answers, int index){
        int start = random.nextInt(5)+1;

        int[] arr = new int[5];
        for(int i = 0; i < 5; i++){
            arr[i] = start + i;
        }

        answers[index] = arr.clone();

        int blankIndex = random.nextInt(5);
        arr[blankIndex] = 0;

        return arr;
    }


}