package site.nansan.en.service.problem.enlv1s1c3;

import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common {

    public static ProblemAnswer make(String[] VALUES, List<ImageType>... imageTypes) {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        ImageType imageType = CreateRandom.pickRandomImages(1, imageTypes).get(0);
        List<Integer> answerNumbers = CreateRandom.pickRandomNumbers(4);

        for (int i = 1; i <= 4; i++) {

            Map<String, Object> problemData = new HashMap<>();
            int answerNumber = answerNumbers.get(i - 1);
            String url = MinioUtil.getStaticImageUrl(imageType, answerNumber);
            int type = Common.getType(answerNumber);
            int answerIndex = Common.getAnswerIndex(type, i % 2 == 0);
            List<Integer> candidates = Common.getCandidates(answerNumber, type, i % 2 == 0);

            problemData.put("image", url);
            problemData.put("candidates", List.of(VALUES[candidates.get(0)], VALUES[candidates.get(1)], VALUES[candidates.get(2)]));
            problem.put("problem" + i, problemData);
            answer.put("problem" + i, VALUES[candidates.get(answerIndex)]);
        }

        return ProblemAnswer.from(problem, answer);
    }

    public static int getType(int answerNumber) {
        if (answerNumber == 1)
            return 1;

        if (answerNumber == 2)
            return CreateRandom.generateRandomInt(1, 2);

        if (3 <= answerNumber && answerNumber <= 7)
            return CreateRandom.generateRandomInt(1, 3);

        if (answerNumber == 8)
            return CreateRandom.generateRandomInt(2, 3);

        if (answerNumber == 9)
            return 3;

        return -1;
    }

    public static List<Integer> getCandidates(int answerNumber, int type, boolean isReverse) {

        if (type == 1) {
            return isReverse
                    ? List.of(answerNumber + 2, answerNumber + 1, answerNumber)
                    : List.of(answerNumber, answerNumber + 1, answerNumber + 2);
        }

        if (type == 2) {
            return isReverse
                    ? List.of(answerNumber + 1, answerNumber, answerNumber - 1)
                    : List.of(answerNumber - 1, answerNumber, answerNumber + 1);
        }

        if (type == 3) {
            return isReverse
                    ? List.of(answerNumber, answerNumber - 1, answerNumber - 2)
                    : List.of(answerNumber - 2, answerNumber - 1, answerNumber);
        }

        return null;
    }

    public static int getAnswerIndex(int type, boolean isReverse) {

        return (isReverse ? 4 - type : type) - 1;
    }
}
