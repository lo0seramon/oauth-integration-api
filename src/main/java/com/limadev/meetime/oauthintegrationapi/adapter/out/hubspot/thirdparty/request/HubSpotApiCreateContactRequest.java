package com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HubSpotApiCreateContactRequest {
    private Properties properties;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Properties {
        private String email;
        @JsonProperty("firstname")
        private String firstName;
        @JsonProperty("lastname")
        private String lastName;
        private String phone;
    }
}
