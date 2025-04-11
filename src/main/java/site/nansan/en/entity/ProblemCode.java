package site.nansan.en.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
public enum ProblemCode {

    /**
     * Level 1: Subject 1
     */
    // Chapter 1
    enlv1s1c1jy1(ChapterCode.enlv1s1c1),
    // Chapter 2
    enlv1s1c2gn1(ChapterCode.enlv1s1c2),
    enlv1s1c2jy1(ChapterCode.enlv1s1c2),
    // Chapter 3
    enlv1s1c3gn1(ChapterCode.enlv1s1c3),
    enlv1s1c3jy1(ChapterCode.enlv1s1c3),
    enlv1s1c3jy2(ChapterCode.enlv1s1c3),
    enlv1s1c3jy3(ChapterCode.enlv1s1c3),
    // Chapter 4
    enlv1s1c4gn1(ChapterCode.enlv1s1c4),
    enlv1s1c4gn2(ChapterCode.enlv1s1c4),
    enlv1s1c4gn3(ChapterCode.enlv1s1c4),


    /**
     * Level 1: Subject 2
     */
    // Chapter 1
    enlv1s2c1gn1(ChapterCode.enlv1s2c1),
    enlv1s2c1jy1(ChapterCode.enlv1s2c1),
    // Chapter 2
    enlv1s2c2gn1(ChapterCode.enlv1s2c2),
    enlv1s2c2gn2(ChapterCode.enlv1s2c2),
    // Chapter 3
    enlv1s2c3gn1(ChapterCode.enlv1s2c3),


    /**
     * Level 1: Subject 3
     */
    // Chapter 1
    // Chapter 2
    enlv1s3c2kc1(ChapterCode.enlv1s3c2),
    enlv1s3c2jy1(ChapterCode.enlv1s3c2),
    // Chapter 3


    /**
     * Level 1: Subject 4
     */
    // Chapter 1
    // Chapter 2
    enlv1s4c2jy1(ChapterCode.enlv1s4c2),
    // Chapter 3


    /**
     * Level 2: Subject 1
     */
    // Chapter 1
    enlv2s1c1gn1(ChapterCode.enlv2s1c1),
    enlv2s1c1gn2(ChapterCode.enlv2s1c1),
    enlv2s1c1jy1(ChapterCode.enlv2s1c1),
    // Chapter 2
    enlv2s1c2gn1(ChapterCode.enlv2s1c2),
    enlv2s1c2jy1(ChapterCode.enlv2s1c2),
    enlv2s1c2jy2(ChapterCode.enlv2s1c2),
    ;

    private final ChapterCode chapterCode;


    // static
    private static final Map<String, List<String>> PROBLEM_CODE_LIST_MAP;

    private static final Map<String, String> NEXT_PROBLEM_CODE_MAP;

    private static final Map<String, ProblemProgress> PROGRESS_MAP;

    // static 블록은 클래스가 처음 로딩될 때 위에서 아래로 순서대로 한 번만 실행
    static {

        Map<String, List<String>> problemCodeListMap = new HashMap<>();
        ProblemCode[] problemCodes = ProblemCode.values();

        for (ProblemCode problemCode : problemCodes) {

            String chapterCode = problemCode.getChapterCode().name();

            problemCodeListMap.computeIfAbsent(chapterCode, s -> new ArrayList<>());
            problemCodeListMap.get(chapterCode).add(problemCode.name());
        }

        PROBLEM_CODE_LIST_MAP = Collections.unmodifiableMap(problemCodeListMap);
    }

    static {

        Map<String, String> nextProblemCodeMap = new HashMap<>();
        ProblemCode[] problemCodes = ProblemCode.values();
        ProblemCode curProblemCode = problemCodes[0];
        int nProblemCode = problemCodes.length;

        for (int i = 1; i < nProblemCode; i++) {

            if (curProblemCode.getChapterCode() == problemCodes[i].getChapterCode()) {
                nextProblemCodeMap.put(curProblemCode.name(), problemCodes[i].name());
            }
            curProblemCode = problemCodes[i];
        }

        NEXT_PROBLEM_CODE_MAP = Collections.unmodifiableMap(nextProblemCodeMap);
    }

    static {

        Map<String, ProblemProgress> progressMap = new HashMap<>();
        ProblemCode[] problemCodes = ProblemCode.values();
        String chapterCode = "";
        int currentProblemNumber = 1;
        int totalProblemCount = 0;

        for (ProblemCode problemCode : problemCodes) {

            String currentChapterCode = problemCode.getChapterCode().name();

            if (!chapterCode.equals(currentChapterCode)) {

                chapterCode = currentChapterCode;
                currentProblemNumber = 1;
                totalProblemCount = PROBLEM_CODE_LIST_MAP.get(chapterCode).size();
            }

            ProblemProgress problemProgress = ProblemProgress.from(currentProblemNumber++, totalProblemCount);
            progressMap.put(problemCode.name(), problemProgress);
        }

        PROGRESS_MAP = Collections.unmodifiableMap(progressMap);
    }

    public static List<String> getProblemCodeList(String chapterCode) {

        return PROBLEM_CODE_LIST_MAP.get(chapterCode);
    }

    public static String getNextProblemCode(String problemCode) {

        return NEXT_PROBLEM_CODE_MAP.get(problemCode);
    }

    public static ProblemProgress getProblemProgress(String problemCode) {

        return PROGRESS_MAP.get(problemCode);
    }
}
