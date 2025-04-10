package com.limadev.meetime.oauthintegrationapi.application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDomain {

    private String id;
    private String accessToken;
    private int expiresIn;
    private String refreshToken;
    private String tokenType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
