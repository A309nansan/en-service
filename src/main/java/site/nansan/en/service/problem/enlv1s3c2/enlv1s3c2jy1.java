package site.nansan.en.service.problem.enlv1s3c2;

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
public class enlv1s3c2jy1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        ImageType imageType = CreateRandom.pickRandomImages(1, ImageType.CONCRETE_TYPE).get(0);
        int type = CreateRandom.generateRandomInt(0, 1);
        int problemValue = type == 0 ? CreateRandom.generateRandomInt(1, 8) : CreateRandom.generateRandomInt(2, 9);
        int answerValue = type == 0 ? problemValue + 1 : problemValue - 1;
        List<Integer> options = CreateRandom.pickRandomNumbers(answerValue, 1, 2);
        List<String> images = new ArrayList<>();

        for (int option : options) {

            images.add(MinioUtil.getStaticImageUrl(imageType, option));
        }

        problem.put("value", problemValue);
        problem.put("options", options);
        problem.put("type", type);
        problem.put("images", images);
        answer.put("value", answerValue);

        return ProblemAnswer.from(problem, answer);
    }
}
