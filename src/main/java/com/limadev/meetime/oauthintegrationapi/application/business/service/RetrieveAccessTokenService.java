package com.limadev.meetime.oauthintegrationapi.application.business.service;

import com.limadev.meetime.oauthintegrationapi.application.business.port.in.RetrieveAccessTokenUseCase;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.RetrieveAccessTokenPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveAccessTokenService implements RetrieveAccessTokenUseCase {
    private final RetrieveAccessTokenPort retrieveAccessTokenPort;

    @Override
    public String retrieveAccessToken() {
        return retrieveAccessTokenPort.getLastAccessToken();
    }
}
