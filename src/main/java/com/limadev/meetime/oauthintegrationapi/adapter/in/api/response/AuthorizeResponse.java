package com.limadev.meetime.oauthintegrationapi.adapter.in.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorizeResponse {

    @JsonProperty("authorization_url")
    private String authorizationUrl;
}
