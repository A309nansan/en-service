package site.nansan.en.service.problem.enlv2s1c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class enlv2s1c2gn1 extends ProblemService {
    private static final String[] UNIT_IMAGES = {
            "apple", "banana", "carrot", "corn", "fish", "grape", "soccerball", "turtle"
    };

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        int first = CreateRandom.generateRandomInt(11, 19);

        String imageName = UNIT_IMAGES[CreateRandom.generateRandomInt(0, UNIT_IMAGES.length - 1)];
        String imageUrl = MinioUtil.getStaticImageUrl(imageName, "number", "unit");

        problem.put("value", first);
        problem.put("img", imageUrl);
        problem.put("number_text", numberToKorean(first));

        return ProblemAnswer.from(problem, answer);
    }

    private String numberToKorean(int number){
        String[] koreannumber = {
          "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"
        };
        int ones = number % 10;

        StringBuilder result = new StringBuilder();
        result.append("십");
        if(ones>0){
            result.append(koreannumber[ones]);
        }
        return result.toString();
    }
}
