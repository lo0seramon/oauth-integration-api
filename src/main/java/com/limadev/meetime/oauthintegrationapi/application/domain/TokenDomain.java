package com.limadev.meetime.oauthintegrationapi.application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDomain {

    private String accessToken;
    private int expiresIn;
    private String refreshToken;
    private String tokenType;
}
