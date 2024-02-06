package org.umc.peerre.domain.feedback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.umc.peerre.domain.feedback.dto.request.FeedbackRequest;
import org.umc.peerre.domain.feedback.service.FeedbackService;
import org.umc.peerre.global.common.SuccessResponse;

@RequiredArgsConstructor
@RestController
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Operation(summary = "피드백 등록(수정)")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK, 피드백 등록(수정) 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "Error Code",description = "Error message",
                    content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
    })
    @PostMapping("projects/{projectId}/users/{userId}/{teamUserId}/feedback")
    public ResponseEntity<SuccessResponse<?>> enrollFeedback(@PathVariable("userId") Long userId,@PathVariable("teamUserId") Long teamUserId, @PathVariable("projectId")Long projectId
            , @RequestBody FeedbackRequest.Feedback request) {

        //Long userId=Long.parseLong(authentication.getName());

        String response = feedbackService.enrollFeedback(userId, teamUserId,projectId,request);

        return SuccessResponse.ok(response);
    }
/**
 * 로그인 완성되면 주석친 메서드로 변경 예정
 *
    @Operation(summary = "피드백 등록(수정)")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK, 피드백 등록(수정) 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "Error Code",description = "Error message",
                    content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
    })
    @PostMapping("projects/{projectId}/users/{teamUserId}/feedback")
    public ResponseEntity<SuccessResponse<?>> enrollFeedback(Authentication authentication,@PathVariable("teamUserId") Long teamUserId, @PathVariable("projectId")Long projectId
            , @RequestBody FeedbackRequest.Feedback request) {

        Long userId=Long.parseLong(authentication.getName());

        String response = feedbackService.enrollFeedback(userId, teamUserId,projectId,request);

        return SuccessResponse.ok(response);
    }

 */
}
