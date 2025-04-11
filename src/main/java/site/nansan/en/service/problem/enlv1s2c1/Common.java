package site.nansan.en.service.problem.enlv1s2c1;

import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common {

    public static ProblemAnswer make(boolean isReverse) {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        final String[] LOW = {"빨강이", "주황이", "노랑이"};
        final String[] MID = {"초록이", "파랑이", "보랭이"};
        final String[] HIGH = {"갈색이", "검정이", "분홍이"};

        List<String> color = List.of(
                LOW[CreateRandom.generateRandomInt(0, 2)],
                MID[CreateRandom.generateRandomInt(0, 2)],
                HIGH[CreateRandom.generateRandomInt(0, 2)]
        );

        for (int i = 0; i < 3; i++) {

            Map<String, String> person = new HashMap<>();
            String imageUrl = MinioUtil.getStaticImageUrl(color.get(i), "problem", Person.getPerson(i).name());

            person.put("image", imageUrl);
            person.put("name", color.get(i));
            problem.put("person" + (i + 1), person);
            answer.put("problem" + (isReverse ? (3 - i) : (i + 1)), color.get(i));
        }

        return ProblemAnswer.from(problem, answer);
    }
}
