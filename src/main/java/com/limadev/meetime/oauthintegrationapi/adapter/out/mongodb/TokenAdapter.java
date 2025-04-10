package com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb;

import com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.entity.TokenEntity;
import com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.repository.TokenRepository;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.AddTokenPort;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.RetrieveAccessTokenPort;
import com.limadev.meetime.oauthintegrationapi.application.domain.TokenDomain;
import com.limadev.meetime.oauthintegrationapi.common.exception.TokenNotFoundException;
import com.limadev.meetime.oauthintegrationapi.common.mapper.TokenMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenAdapter implements AddTokenPort, RetrieveAccessTokenPort {

    private final TokenMapper tokenMapper;
    private final TokenRepository tokenRepository;

    @Override
    public void create(TokenDomain tokenDomain) {
        TokenEntity tokenEntity = tokenMapper.toEntity(tokenDomain);

        tokenRepository.save(tokenEntity);
    }

    @Override
    public String getLastAccessToken() {
        return tokenRepository
                .findFirstByOrderByCreatedAtDesc()
                .orElseThrow(() -> new TokenNotFoundException("Token não encontrado"))
                .getAccessToken();
    }
}
