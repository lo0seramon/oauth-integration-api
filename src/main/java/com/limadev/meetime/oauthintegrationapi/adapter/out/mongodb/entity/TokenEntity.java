package com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.entity;

import com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.entity.auditor.Auditor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
