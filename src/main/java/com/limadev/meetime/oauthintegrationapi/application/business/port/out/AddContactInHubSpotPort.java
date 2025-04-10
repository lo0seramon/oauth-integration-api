package com.limadev.meetime.oauthintegrationapi.application.business.port.out;

import com.limadev.meetime.oauthintegrationapi.application.domain.ContactDomain;

public interface AddContactInHubSpotPort {
    void addContact(String authorizationHeader, ContactDomain contact);
}
