package com.limadev.meetime.oauthintegrationapi.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OuathIntegrationApiException extends RuntimeException {

    private final HttpStatus status;

    public OuathIntegrationApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
