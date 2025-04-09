package com.limadev.meetime.oauthintegrationapi.common.exception;

import com.limadev.meetime.oauthintegrationapi.common.exception.response.ErrorResponse;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class OauthIntegrationApiExceptionHandler {

    @ExceptionHandler(OuathIntegrationApiException.class)
    public ResponseEntity<ErrorResponse> handleOauthIntegrationApiException(OuathIntegrationApiException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(ErrorResponse
                        .builder()
                        .timestamp(Instant.now())
                        .status(e.getStatus().value())
                        .error(e.getStatus().getReasonPhrase())
                        .message(e.getMessage())
                        .build());
    }
}
