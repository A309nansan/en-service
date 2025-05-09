package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

import java.util.*;

@Service
public class enlv1s2c3jy4 extends ProblemService {
    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();
        Random random = new Random();

        int start = random.nextInt(5) + 5;
        List<Integer> fullList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fullList.add(start - i);
        }

        List<Integer> visibleList = Arrays.asList(fullList.get(0), fullList.get(2), fullList.get(4));
        problem.put("list", visibleList);

        int numberIndex = random.nextBoolean() ? 1 : 3;
        int number = fullList.get(numberIndex);
        problem.put("number", number);

        answer.put("left", numberIndex == 1);
        answer.put("right", numberIndex == 3);

        return ProblemAnswer.from(problem, answer);
    }
}