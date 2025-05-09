package site.nansan.en.service.problem.enlv1s3c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;

import java.util.*;

@Service
public class enlv1s3c1kc1 extends ProblemService {
    @Override
    public ProblemAnswer makeProblemAnswer() {
        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<Integer> pool = Arrays.asList(1, 2, 5);
        Collections.shuffle(pool);
        List<Integer> p1 = new ArrayList<>();
        p1.add(4);
        p1.addAll(pool.subList(0, 2));
        Collections.shuffle(p1);

        List<Integer> p1Sorted = new ArrayList<>(p1);
        Collections.sort(p1Sorted);
        List<Integer> p2 = new ArrayList<>();
        p2.add(3);
        p2.addAll(p1Sorted);

        problem.put("p1", p1);
        problem.put("p2", p2);

        answer.put("p1", p1);
        answer.put("p2", 4);


        return ProblemAnswer.from(problem, answer);

    }
}
