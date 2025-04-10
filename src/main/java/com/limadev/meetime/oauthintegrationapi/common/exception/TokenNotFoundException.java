package com.limadev.meetime.oauthintegrationapi.common.exception;

import org.springframework.http.HttpStatus;

public class TokenNotFoundException extends OuathIntegrationApiException {
    public TokenNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
