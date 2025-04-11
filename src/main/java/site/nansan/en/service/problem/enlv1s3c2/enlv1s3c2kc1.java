package site.nansan.en.service.problem.enlv1s3c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.*;

@Service
public class enlv1s3c2kc1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        int maxStart = 5;
        int start = CreateRandom.generateRandomInt(1, maxStart);

        List<Integer> fullSequence = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fullSequence.add(start + i);
        }
        ImageType imageType = CreateRandom.pickRandomImages(1, ImageType.CONCRETE_TYPE).get(0);

        List<Integer> options = new ArrayList<>();
        List<String> images = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                options.add(fullSequence.get(i));
                String imageUrl = MinioUtil.getStaticImageUrl(imageType, fullSequence.get(i));
                images.add(imageUrl);
            } else {
                options.add(null);
                images.add(null);
            }
        }

        int[] gapIndices = {1, 3};
        int gapChoiceIndex = gapIndices[CreateRandom.generateRandomInt(0, 1)];
        int correctValue = fullSequence.get(gapChoiceIndex);

        Map<String, Object> problem = new HashMap<>();
        problem.put("value", correctValue);
        problem.put("options", options);
        problem.put("images", images);

        Map<String, Object> answer = new HashMap<>();
        answer.put("value", gapChoiceIndex);

        return ProblemAnswer.from(problem, answer);
    }
}
