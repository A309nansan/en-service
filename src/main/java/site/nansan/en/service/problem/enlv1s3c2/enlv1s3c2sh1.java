package site.nansan.en.service.problem.enlv1s3c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

import java.util.*;

@Service
public class enlv1s3c2sh1 extends ProblemService {
    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();
        Random random = new Random();

        int p1Start = random.nextInt(5);
        List<Integer> p1 = Arrays.asList(p1Start + 1, p1Start + 2);

        int p2Start = random.nextInt(4) + 6;
        if (p2Start == 9) p2Start = 8;
        List<Integer> p2 = Arrays.asList(p2Start, p2Start + 1);

        answer.put("a1", Math.min(p1.get(0), p1.get(1)));
        answer.put("a2", Math.min(p2.get(0), p2.get(1)));

        problem.put("p1", p1);
        problem.put("p2", p2);

        return ProblemAnswer.from(problem, answer);
    }
}
