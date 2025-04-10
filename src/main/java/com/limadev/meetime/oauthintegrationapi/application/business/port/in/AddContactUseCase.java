package com.limadev.meetime.oauthintegrationapi.application.business.port.in;

import com.limadev.meetime.oauthintegrationapi.adapter.in.api.request.CreateContactRequest;

public interface AddContactUseCase {
    void createContact(CreateContactRequest contactRequest);
}
