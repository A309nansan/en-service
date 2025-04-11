package site.nansan.en.service.problem.enlv1s1c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class enlv1s1c3gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<Integer> answers = CreateRandom.pickRandomNumbers(2, 0, 3);
        ImageType imageType = CreateRandom.pickRandomImages(1, ImageType.CONCRETE_TYPE).get(0);

        problem.put("example", MinioUtil.getStaticImageUrl(imageType, 2));

        for (int i = 1; i <= 3; i++) {

            problem.put("p" + i, MinioUtil.getStaticImageUrl(imageType, answers.get(i - 1)));
            answer.put("p" + i, answers.get(i - 1));
        }

        return ProblemAnswer.from(problem, answer);
    }
}
