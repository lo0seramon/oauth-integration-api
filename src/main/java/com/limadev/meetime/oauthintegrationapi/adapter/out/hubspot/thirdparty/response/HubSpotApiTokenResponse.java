package com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HubSpotApiTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType;
}
