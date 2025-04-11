package site.nansan.global.util;

import site.nansan.en.entity.ImageType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreateRandom {

    /**
     * @param start 이상
     * @param end   이하
     * @return : 범위 내의 정수 값
     */
    public static int generateRandomInt(int start, int end) {

        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    /**
     * @param nPick      뽑을 후보군 갯수
     * @param imageTypes 후보군 그룹
     * @return : 후보군 중에서 중복 없이 n개를 뽑은 결과
     */
    @SafeVarargs
    public static List<ImageType> pickRandomImages(
            int nPick,
            List<ImageType>... imageTypes
    ) {

        List<ImageType> imageTypeList = new ArrayList<>();

        for (List<ImageType> imageType : imageTypes) {
            imageTypeList.addAll(imageType);
        }
        Collections.shuffle(imageTypeList);

        return imageTypeList.subList(0, nPick);
    }

    /**
     * @param nPick 뽑을 갯수
     * @return : 1 ~ 9 중에서 중복 없이 n개 뽑기
     */
    public static List<Integer> pickRandomNumbers(int nPick) {

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Collections.shuffle(numbers); // 리스트 섞기
        return numbers.subList(0, nPick); // 앞에서 n개만 추출
    }

    /**
     * @param correctNumber  정답인 정수 값
     * @param nCorrect 정답 갯수
     * @param nWrong   오답 갯수
     * @return : 정답이 n개, 오답이 중복없이 m개가 담긴 리스트
     */
    public static List<Integer> pickRandomNumbers(int correctNumber, int nCorrect, int nWrong) {

        List<Integer> candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        candidates.remove((Integer) correctNumber);
        Collections.shuffle(candidates);

        List<Integer> result = new ArrayList<>(candidates.subList(0, nWrong));

        for (int i = 0; i < nCorrect; i++) {
            result.add(correctNumber);
        }

        Collections.shuffle(result);
        return result;
    }
}
