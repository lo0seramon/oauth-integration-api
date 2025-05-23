package com.limadev.meetime.oauthintegrationapi.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class HubSpotApiCredentials {
    @Value("${hubspot.client-id}")
    private String clientId;

    @Value("${hubspot.client-secret}")
    private String clientSecret;

    @Value("${hubspot.redirect-uri}")
    private String redirectUri;

    @Value("${hubspot.scope}")
    private String scope;
}
