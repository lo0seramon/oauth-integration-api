package com.limadev.meetime.oauthintegrationapi.application.business.service;

import com.limadev.meetime.oauthintegrationapi.application.business.port.in.GetAuthorizationUrlUseCase;
import com.limadev.meetime.oauthintegrationapi.common.config.HubSpotApiCredentials;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAuthorizationUrlService implements GetAuthorizationUrlUseCase {

    private final HubSpotApiCredentials hubSpotApiCredentials;

    @Override
    public String getAuthorizationUrl() {
        return UriComponentsBuilder
                .fromUri(URI.create("https://app.hubspot.com/oauth/authorize"))
                .queryParam("client_id", hubSpotApiCredentials.getClientId())
                .queryParam("redirect_uri", hubSpotApiCredentials.getRedirectUri())
                .queryParam("scope", hubSpotApiCredentials.getScope())
                .build().encode().toUriString();
    }

}
