package site.nansan.en.service.problem.enlv2s1c1;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.*;

@Service
public class enlv2s1c1gn1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        List<Object> line = new ArrayList<>();
        List<ImageType> imageTypes = CreateRandom.pickRandomImages(4, ImageType.CARD_TYPE, List.of(ImageType.numeric2));

        List<Integer> left = CreateRandom.pickRandomNumbers(4);
        List<Integer> right = left.stream().map(n -> 10 - n).toList();

        List<Object[]> leftList = new ArrayList<>();
        List<Object[]> rightList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            leftList.add(new Object[] {left.get(i), MinioUtil.getStaticImageUrl(imageTypes.get(i), left.get(i))});
            rightList.add(new Object[] {right.get(i), MinioUtil.getStaticImageUrl(imageTypes.get(i), right.get(i))});
        }
        Collections.shuffle(rightList);

        for (int i = 0; i < 4; i++) {

            Map<String, Object> map = new HashMap<>();

            map.put("left", leftList.get(i)[0]);
            map.put("left_img", leftList.get(i)[1]);
            map.put("right", rightList.get(i)[0]);
            map.put("right_img", rightList.get(i)[1]);
            line.add(map);
        }
        problem.put("line", line);

        return ProblemAnswer.from(problem, answer);
    }
}
