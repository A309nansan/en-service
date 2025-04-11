package site.nansan.en.service.problem.enlv2s1c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class enlv2s1c1gn2 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<Object> candidates = new ArrayList<>();
        List<Object> values = new ArrayList<>();

        List<Integer> first = CreateRandom.pickRandomNumbers(8);
        List<Integer> second = CreateRandom.pickRandomNumbers(8);
        List<ImageType> imageTypes = CreateRandom.pickRandomImages(9, ImageType.CARD_TYPE, ImageType.CARD_TYPE, ImageType.CARD_TYPE);

        int correct = CreateRandom.generateRandomInt(1, 9);

        first.add(correct);
        second.add(10 - correct);
        for (int i = 0; i < 9; i++) {

            Map<String, Object> problemMap = new HashMap<>();
            Map<String, Object> answerMap = new HashMap<>();
            ImageType imageType = imageTypes.get(i);
            int sumValue = first.get(i) + second.get(i);
            String[] images = new String[]{
                    MinioUtil.getStaticImageUrl(imageType, first.get(i)),
                    MinioUtil.getStaticImageUrl(imageType, second.get(i))
            };

            problemMap.put("value", sumValue);
            problemMap.put("images", images);
            answerMap.put("value", sumValue);
            candidates.add(problemMap);
            values.add(answerMap);
        }

        problem.put("candidates", candidates);
        answer.put("values", values);
        return ProblemAnswer.from(problem, answer);
    }
}
