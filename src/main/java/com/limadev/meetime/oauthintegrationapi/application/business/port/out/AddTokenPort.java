package com.limadev.meetime.oauthintegrationapi.application.business.port.out;

import com.limadev.meetime.oauthintegrationapi.application.domain.TokenDomain;

public interface AddTokenPort {
    void create(TokenDomain tokenDomain);
}
