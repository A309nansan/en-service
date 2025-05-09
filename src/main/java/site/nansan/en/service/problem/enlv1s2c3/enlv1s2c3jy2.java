package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

import java.util.*;

@Service
public class enlv1s2c3jy2 extends ProblemService {
    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        boolean ascending = new Random().nextBoolean();
        if (!ascending) {
            numbers.sort(Comparator.reverseOrder());
        }

        problem.put("numbers", numbers);

        for (int i = 0; i < numbers.size(); i++) {
            answer.put("p" + (i + 1), numbers.get(i));
        }

        return ProblemAnswer.from(problem, answer);
    }
}