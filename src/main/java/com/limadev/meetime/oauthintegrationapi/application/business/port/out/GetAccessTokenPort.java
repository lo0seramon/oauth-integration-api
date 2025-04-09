package com.limadev.meetime.oauthintegrationapi.application.business.port.out;

import com.limadev.meetime.oauthintegrationapi.application.domain.TokenDomain;

public interface GetAccessTokenPort {
    TokenDomain exchangeCodeForToken(String code);
}
