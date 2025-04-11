package site.nansan.en.service.problem.enlv1s1c2;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.entity.ImageType;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;
import site.nansan.global.util.MinioUtil;

import java.util.*;

@Service
public class enlv1s1c2jy1 extends ProblemService {

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        Map<String, Object> fixed = new HashMap<>();
        List<Map<String, String>> candidates = new ArrayList<>();

        ImageType imageType = CreateRandom.pickRandomImages(1, ImageType.CONCRETE_TYPE).get(0);
        ImageType[] items = new ImageType[]{
                imageType, ImageType.dot, ImageType.numeric1, ImageType.hangeul1
        };

        for (ImageType item : items) {

            List<String> urls = new ArrayList<>();

            for (int idx = 4; idx <= 5; idx++) {

                urls.add(MinioUtil.getStaticImageUrl(item, idx));
            }
            fixed.put(item.name(), urls);

            List<Map<String, String>> imageNames = new ArrayList<>();

            for (int idx = 1; idx <= 3; idx++) {

                Map<String, String> candidate = new HashMap<>();
                Map<String, String> names = new HashMap<>();

                String url = MinioUtil.getStaticImageUrl(item, idx);
                String imageName = item.name() + "_" + idx;

                candidate.put("image_url", url);
                candidate.put("image_name", imageName);
                candidates.add(candidate);

                names.put("image_name", imageName);
                imageNames.add(names);
            }
            answer.put(item.name(), imageNames);
        }
        Collections.shuffle(candidates);

        problem.put("fixed", fixed);
        problem.put("candidates", candidates);

        return ProblemAnswer.from(problem, answer);
    }
}
