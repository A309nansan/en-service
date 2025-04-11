package site.nansan.en.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import site.nansan.en.controller.EnSwaggerController;
import site.nansan.en.dto.command.ProblemCommand;
import site.nansan.en.dto.command.ProblemCodesCommand;
import site.nansan.en.dto.command.SolvedProblemCommand;
import site.nansan.en.dto.request.ProblemRequest;
import site.nansan.en.dto.request.ProblemCodesRequest;
import site.nansan.en.dto.request.SolvedProblemRequest;
import site.nansan.en.dto.response.ProblemResponse;
import site.nansan.en.dto.response.ProblemCodesResponse;
import site.nansan.en.service.DispatcherService;
import site.nansan.en.service.EnService;

@RestController
@RequiredArgsConstructor
public class EnController implements EnSwaggerController {

    private final DispatcherService dispatcherService;
    private final EnService enService;

    @Override
    public ResponseEntity<ProblemCodesResponse> getProblemCodes(ProblemCodesRequest request) {

        ProblemCodesResponse response = ProblemCodesResponse.from(
                enService.getProblemCodes(ProblemCodesCommand.from(request))
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ProblemResponse> makeProblem(ProblemRequest request) {

        ProblemResponse response = ProblemResponse.from(
                dispatcherService.dispatchMakeProblem(ProblemCommand.from(request))
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<String> saveSolvedProblem(Long userId, SolvedProblemRequest request) {

        request.setUserId(userId);

        enService.saveProblem(SolvedProblemCommand.from(request));

        return ResponseEntity.ok("성공적으로 저장되었습니다.");
    }

}
