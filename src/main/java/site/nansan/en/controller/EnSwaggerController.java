package site.nansan.en.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import site.nansan.en.dto.request.ProblemRequest;
import site.nansan.en.dto.request.ProblemCodesRequest;
import site.nansan.en.dto.request.SolvedProblemRequest;
import site.nansan.en.dto.response.ProblemResponse;
import site.nansan.en.dto.response.ProblemCodesResponse;

public interface EnSwaggerController {

    @Operation(summary = "Get Problem Code List in Chapter Code", description = "Chapter Code에 속하는 Problem Code들을 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 코드 리스트 조회"),
    })
    @PostMapping("/problem/code")
    ResponseEntity<ProblemCodesResponse> getProblemCodes(@Valid @RequestBody ProblemCodesRequest request);

    @Operation(summary = "Make Problem by Problem Code", description = "Problem Code에 해당하는 문제를 생성해 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 문제 생성"),
    })
    @PostMapping("/problem/make")
    ResponseEntity<ProblemResponse> makeProblem(@Valid @RequestBody ProblemRequest request);

    @Operation(summary = "Save Solved Problem", description = "푼 문제를 저장합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 문제 저장"),
    })
    @PostMapping("/problem/save")
    ResponseEntity<String> saveSolvedProblem(
            @RequestHeader("X-User-Id") Long userId,
            @Valid @RequestBody SolvedProblemRequest request
    );
}
