package com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.entity;

import com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.entity.auditor.Auditor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("tokens")
public class TokenEntity extends Auditor {

    private String accessToken;
    private int expiresIn;
    private String refreshToken;
    private String tokenType;
}
