package com.limadev.meetime.oauthintegrationapi.application.business.port.in;

import com.limadev.meetime.oauthintegrationapi.adapter.in.api.request.CreateContactRequest;
import com.limadev.meetime.oauthintegrationapi.application.domain.ContactDomain;

public interface AddContactUseCase {
    void createContact(ContactDomain contact);
}
