package com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.request;

import lombok.Data;

@Data
public class HubSpotApiCreateContactRequest {
    private CreateContactData createContactData;

    @Data
    public static class CreateContactData {
        private String firstName;
        private String lastName;
        private String email;
    }
}
