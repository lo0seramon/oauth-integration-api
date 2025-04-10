package com.limadev.meetime.oauthintegrationapi.application.business.service;

import com.limadev.meetime.oauthintegrationapi.adapter.in.api.request.CreateContactRequest;
import com.limadev.meetime.oauthintegrationapi.application.business.port.in.AddContactUseCase;
import com.limadev.meetime.oauthintegrationapi.application.business.port.in.RetrieveAccessTokenUseCase;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.AddContactInHubSpotPort;
import com.limadev.meetime.oauthintegrationapi.application.domain.ContactDomain;
import com.limadev.meetime.oauthintegrationapi.common.exception.RateLimitException;
import io.github.bucket4j.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddContactService implements AddContactUseCase {

    private final AddContactInHubSpotPort addContactInHubSpotPort;
    private final RetrieveAccessTokenUseCase retrieveAccessTokenUseCase;
    private final Bucket bucket;

    @Override
    public void createContact(ContactDomain contactDomain) {
        if (!bucket.tryConsume(1)) {
            throw new RateLimitException("Limite de requisições excedido");
        }

        String authorizationHeader = generateAuthorizationHeader();

        addContactInHubSpotPort.addContact(authorizationHeader,contactDomain);
    }

    private String generateAuthorizationHeader() {
        return "Bearer " + retrieveAccessTokenUseCase.retrieveAccessToken();
    }
}
