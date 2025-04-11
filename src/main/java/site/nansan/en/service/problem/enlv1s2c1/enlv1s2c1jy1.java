package site.nansan.en.service.problem.enlv1s2c1;

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
public class enlv1s2c1jy1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        final String[] TEXT = {"영째", "첫째", "둘째", "셋째", "넷째", "다섯째", "여섯째", "일곱째", "여덟째", "아홉째"};

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<String> imageUrls = new ArrayList<>();
        List<Integer> answers = CreateRandom.pickRandomNumbers(4);

        for (int i = 1; i <= 9; i++) {

            imageUrls.add(MinioUtil.getStaticImageUrl(ImageType.zodiac, i));
        }
        problem.put("image_url", imageUrls);

        for (int i = 0; i < 4; i++) {

            Map<String, Object> problemMap = new HashMap<>();
            Map<String, Object> answerMap = new HashMap<>();
            List<String> urls = new ArrayList<>();
            List<Integer> candidates = CreateRandom.pickRandomNumbers(answers.get(i), 1, 3);

            for (int candidate : candidates) {

                urls.add(MinioUtil.getStaticImageUrl(ImageType.zodiac, candidate));
            }

            problemMap.put("text", TEXT[answers.get(i)]);
            problemMap.put("urls", urls);
            problemMap.put("candidates", candidates);
            answerMap.put("number", answers.get(i));
            problem.put("p" + (i + 1), problemMap);
            answer.put("p" + (i + 1), answerMap);
        }

        return ProblemAnswer.from(problem, answer);
    }
}
