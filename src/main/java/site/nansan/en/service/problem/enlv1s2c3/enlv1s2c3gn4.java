package site.nansan.en.service.problem.enlv1s2c3;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.util.ProblemAnswer;
import site.nansan.en.service.ProblemService;
import site.nansan.global.util.CreateRandom;

import java.util.*;

@Service
public class enlv1s2c3gn4 extends ProblemService {

    final static String[] ANSWER_CANDIDATE = new String[]{"1-2-3-4", "2-3-4-5", "3-4-5-6", "4-5-6-7", "5-6-7-8", "6-7-8-9"};

    @Override
    public ProblemAnswer makeProblemAnswer() {

        Map<String, Object> problem = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();

        String[][] grid = new String[4][4];
        List<Map<String, Integer>> correctIndexes = new ArrayList<>();
        Set<Integer> isIn = new HashSet<>();
        boolean[][] isFilled = new boolean[4][4];

        List<Integer> answerLocation = CreateRandom
                .pickRandomNumbers(
                        new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)),
                        6
                );

        for (int i = 0; i < 6; i++) {

            Map<String, Integer> location = new HashMap<>();

            int row = answerLocation.get(i) / 4;
            int col = answerLocation.get(i) % 4;

            location.put("row", row);
            location.put("col", col);

            grid[row][col] = ANSWER_CANDIDATE[i];
            correctIndexes.add(location);
            isFilled[row][col] = true;
        }

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {

                if (isFilled[r][c])
                    continue;

                while (true) {

                    List<Integer> list = CreateRandom.pickRandomNumbers(4);

                    if (isUpStream(list) || isDownStream(list))
                        continue;

                    int keyName = getKeyName(list);

                    if (isIn.contains(keyName))
                        continue;
                    isIn.add(keyName);

                    grid[r][c] = getString(list);
                    break;
                }
            }
        }

        problem.put("grid", grid);
        answer.put("count", 6);
        answer.put("correct_indexes", correctIndexes);

        return ProblemAnswer.from(problem, answer);
    }

    private boolean isUpStream(List<Integer> list) {

        return list.get(0) + 1 == list.get(1)
                && list.get(1) + 1 == list.get(2)
                && list.get(2) + 1 == list.get(3);
    }

    private boolean isDownStream(List<Integer> list) {

        return list.get(0) - 1 == list.get(1)
                && list.get(1) - 1 == list.get(2)
                && list.get(2) - 1 == list.get(3);
    }

    private int getKeyName(List<Integer> list) {

        return list.get(0) + list.get(1) * 10 + list.get(2) * 100 + list.get(3) * 1000;
    }

    private String getString(List<Integer> list) {

        return list.get(0) + "-" + list.get(1) + "-" + list.get(2) + "-" + list.get(3);
    }
}
