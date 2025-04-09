package com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty;

import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.request.HubSpotApiCreateContactRequest;
import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.response.HubSpotApiTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(
        value = "hub-spot-api-client",
        url = "${hubspot.api-base-uri}"
)
public interface HubSpotApiClient {

        @PostMapping(value = "/oauth/v1/token", consumes = APPLICATION_FORM_URLENCODED_VALUE)
        HubSpotApiTokenResponse exchangeForToken(@RequestParam("grant_type") String grantType,
                                              @RequestParam("client_id") String clientId,
                                              @RequestParam("client_secret") String clientSecret,
                                              @RequestParam("redirect_uri") String redirectUri,
                                              @RequestParam("code") String code);

        @PostMapping(value = "/crm/v3/objects/contact", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_FORM_URLENCODED_VALUE)
        void createContact(@RequestHeader("Authorization") String authorizationHeader,
                           @RequestBody HubSpotApiCreateContactRequest createContactRequest);
}
