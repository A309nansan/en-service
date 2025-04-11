package site.nansan.en.service;

import site.nansan.en.dto.util.ProblemAnswer;

public abstract class ProblemService {

    public String getProblemCode() {

        return this.getClass().getSimpleName();
    }

    public abstract ProblemAnswer makeProblemAnswer();
}
