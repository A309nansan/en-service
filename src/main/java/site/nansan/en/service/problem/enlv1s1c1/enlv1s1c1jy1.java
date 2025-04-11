package site.nansan.en.service.problem.enlv1s1c1;

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
public class enlv1s1c1jy1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int answerNumber = CreateRandom.generateRandomInt(1, 9);
        int answerCount = CreateRandom.generateRandomInt(3, 5);

        List<ImageType> imageTypes = CreateRandom
                .pickRandomImages(9, ImageType.CONCRETE_TYPE, ImageType.HANGEUL_TYPE, ImageType.NUMERIC_TYPE);
        List<Integer> numbers = CreateRandom
                .pickRandomNumbers(answerNumber, answerCount, 9 - answerCount);

        for (int i = 0; i < 9; i++) {

            Map<String, Object> entry = new HashMap<>();
            String imageUrl = MinioUtil.getStaticImageUrl(imageTypes.get(i), numbers.get(i));

            entry.put("image_url", imageUrl);
            entry.put("number", numbers.get(i));
            problem.put("candidate" + (i + 1), entry);
        }

        answer.put("number", answerNumber);
        answer.put("count", answerCount);

        return ProblemAnswer.from(problem, answer);
    }
}
