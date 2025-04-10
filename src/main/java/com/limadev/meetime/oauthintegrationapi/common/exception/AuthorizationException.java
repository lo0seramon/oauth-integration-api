package com.limadev.meetime.oauthintegrationapi.common.exception;

import org.springframework.http.HttpStatus;

public class AuthorizationException extends OuathIntegrationApiException {
    public AuthorizationException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
