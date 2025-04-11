package site.nansan.en.service;

import org.springframework.stereotype.Service;
import site.nansan.en.dto.command.ProblemCommand;
import site.nansan.en.dto.dto.ProblemDto;
import site.nansan.en.entity.ProblemCode;
import site.nansan.global.exception.EnErrorCode;
import site.nansan.global.exception.EnException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DispatcherService {

    private final Map<String, ProblemService> dispatcherMap = new HashMap<>();

    public DispatcherService(List<ProblemService> problemServiceList) {

        for(ProblemService problemService: problemServiceList) {
            dispatcherMap.put(problemService.getProblemCode(), problemService);
        }
    }

    public ProblemDto dispatchMakeProblem(ProblemCommand problemCommand) {

        String problemCode = problemCommand.getProblemCode();

        ProblemService problemService = Optional.ofNullable(
                dispatcherMap.get(problemCode))
                    .orElseThrow(() -> new EnException(EnErrorCode.INCORRECT_PROBLEM_CODE));

        return ProblemDto.from(
                problemCode,
                ProblemCode.getNextProblemCode(problemCode),
                ProblemCode.getProblemProgress(problemCode),
                problemService.makeProblemAnswer()
        );
    }
}
