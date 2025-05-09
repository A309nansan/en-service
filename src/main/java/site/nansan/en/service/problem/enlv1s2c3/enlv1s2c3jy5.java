package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

import java.util.*;

@Service
public class enlv1s2c3jy5 extends ProblemService {
    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();
        Random random = new Random();

        List<List<String>> choices = new ArrayList<>();
        Set<Integer> usedStarts = new HashSet<>();

        int ascendingIndex = random.nextInt(4);

        while (choices.size() < 4) {
            int start = random.nextInt(6) + 1;
            if (usedStarts.contains(start)) continue;
            usedStarts.add(start);

            List<String> sequence = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                sequence.add(String.valueOf(start + i));
            }

            if (choices.size() == ascendingIndex) {
                choices.add(sequence);
            } else {
                Collections.reverse(sequence);
                choices.add(sequence);
            }
        }

        problem.put("choices", choices);
        answer.put("selectedAnswer", ascendingIndex + 1);

        return ProblemAnswer.from(problem, answer);
    }
}
