package com.limadev.meetime.oauthintegrationapi.application.business.port.in;

public interface AddTokenUseCase {
    void createToken(
            String accessToken,
            int expiresIn,
            String refreshToken,
            String tokenType);
}
