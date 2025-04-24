package site.nansan.en.service.problem.enlv1s1c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class enlv1s1c1gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<Integer> suffledList = CreateRandom.pickRandomNumbers(9);

        problem.put(ImageType.dot.name(), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        problem.put(ImageType.numeric1.name(), suffledList);
        problem.put(ImageType.hangeul1.name(), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        int[][] lineAnswer = new int[2][9];

        for (int i = 0; i < 9; i++) {

            int index = suffledList.get(i) - 1;

            lineAnswer[0][index] = i;
            lineAnswer[1][i] = index;
        }

        for (int i = 1; i <= 2; i++) {

            answer.put("line" + i, lineAnswer[i - 1]);
        }

        return ProblemAnswer.from(problem, answer);
    }
}
