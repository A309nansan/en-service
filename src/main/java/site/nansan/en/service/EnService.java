package site.nansan.en.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.nansan.en.dto.command.ProblemCodesCommand;
import site.nansan.en.dto.command.SolvedProblemCommand;
import site.nansan.en.dto.dto.ProblemCodesDto;
import site.nansan.en.entity.ProblemCode;
import site.nansan.en.entity.SolvedProblem;
import site.nansan.en.repository.SolvedProblemRepository;

@Service
@RequiredArgsConstructor
public class EnService {

    private final SolvedProblemRepository solvedProblemRepository;

    public ProblemCodesDto getProblemCodes(ProblemCodesCommand command) {

        return ProblemCodesDto.from(
                ProblemCode.getProblemCodeList(command.getChapterCode()));
    }

    public void saveProblem(SolvedProblemCommand solvedProblemCommand) {

        solvedProblemRepository.save(SolvedProblem.from(solvedProblemCommand));
    }
}
