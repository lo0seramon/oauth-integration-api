package com.limadev.meetime.oauthintegrationapi.common.exception;

import org.springframework.http.HttpStatus;

public class RateLimitException extends OuathIntegrationApiException {
    public RateLimitException(String message) {
        super(HttpStatus.TOO_MANY_REQUESTS, message);
    }
}
