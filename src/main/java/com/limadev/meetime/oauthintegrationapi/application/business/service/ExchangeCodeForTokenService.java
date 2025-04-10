package com.limadev.meetime.oauthintegrationapi.application.business.service;

import com.limadev.meetime.oauthintegrationapi.application.business.port.in.AddTokenUseCase;
import com.limadev.meetime.oauthintegrationapi.application.business.port.in.ExchangeCodeForTokenUseCase;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.GetAccessTokenPort;
import com.limadev.meetime.oauthintegrationapi.application.domain.TokenDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExchangeCodeForTokenService implements ExchangeCodeForTokenUseCase {

    private final GetAccessTokenPort getAccessTokenPort;
    private final AddTokenUseCase addTokenUseCase;


    @Override
    public void exchangeCodeForToken(String code) {

        TokenDomain token = getAccessTokenPort.exchangeCodeForToken(code);

        addTokenUseCase.createToken(
                token.getAccessToken(),
                token.getExpiresIn(),
                token.getRefreshToken(),
                token.getTokenType()
        );

    }
}
