package com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot;

import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.config.HubSpotApiCredentials;
import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.HubSpotApiClient;
import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.response.HubSpotApiTokenResponse;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.AddContactInHubSpotPort;
import com.limadev.meetime.oauthintegrationapi.application.business.port.out.GetAccessTokenPort;
import com.limadev.meetime.oauthintegrationapi.application.domain.ContactDomain;
import com.limadev.meetime.oauthintegrationapi.application.domain.TokenDomain;
import com.limadev.meetime.oauthintegrationapi.common.exception.HubSpotException;
import com.limadev.meetime.oauthintegrationapi.common.mapper.ContactMapper;
import com.limadev.meetime.oauthintegrationapi.common.mapper.TokenMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HubSpotApiAdapter implements GetAccessTokenPort, AddContactInHubSpotPort {

    @Autowired
    private HubSpotApiClient hubSpotApiClient;

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private HubSpotApiCredentials hubSpotApiCredentials;

    @Override
    public TokenDomain exchangeCodeForToken(String code) {
        log.info("[HubSpotApiAdapter][exchangeCodeForToken] Obtendo token através do código: [{}]", code);

        try {
            HubSpotApiTokenResponse response = hubSpotApiClient.exchangeForToken(
                    "authorization_code",
                    hubSpotApiCredentials.getClientId(),
                    hubSpotApiCredentials.getClientSecret(),
                    hubSpotApiCredentials.getRedirectUri(),
                    code
            );
            return tokenMapper.toDomain(response);
        } catch (Exception e) {
            log.error("Erro ao obter token de accesso", e);
            throw new HubSpotException("Erro ao obter token de accesso");
        }
    }

    @Override
    public void addContact(ContactDomain contact) {
        log.info("[HubSpotApiAdapter][addContact] Adicionando contato [{}] ao CRM", contact.getEmail());
        String authorizationHeader = "Bearer" + "TO DO IMPLEMENT RETRIEVE ACESS TOKEN";

        try {
            hubSpotApiClient.createContact(authorizationHeader, contactMapper.toRequest(contact));
        } catch (Exception e) {
            throw new HubSpotException("Erro ao adcionar contato no CRM");
        }
    }
}
