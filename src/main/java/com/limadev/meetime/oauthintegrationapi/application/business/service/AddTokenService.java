package com.limadev.meetime.oauthintegrationapi.application.business.service;

import com.limadev.meetime.oauthintegrationapi.application.business.port.in.AddTokenUseCase;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.AddTokenPort;
import com.limadev.meetime.oauthintegrationapi.application.domain.TokenDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddTokenService implements AddTokenUseCase {

    private final AddTokenPort addTokenPort;

    @Override
    public void createToken(String accessToken, int expiresIn, String refreshToken, String tokenType) {

        addTokenPort.create(TokenDomain
                .builder()
                .accessToken(accessToken)
                .expiresIn(expiresIn)
                .refreshToken(refreshToken)
                .tokenType(tokenType)
                .build());

    }
}
