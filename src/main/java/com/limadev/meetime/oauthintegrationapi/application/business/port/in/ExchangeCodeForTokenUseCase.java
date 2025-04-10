package com.limadev.meetime.oauthintegrationapi.application.business.port.in;

public interface ExchangeCodeForTokenUseCase {
    void exchangeCodeForToken(String code);
}
