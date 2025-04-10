package com.limadev.meetime.oauthintegrationapi.common.exception;

import org.springframework.http.HttpStatus;

public class HubSpotException extends OuathIntegrationApiException {
    public HubSpotException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
