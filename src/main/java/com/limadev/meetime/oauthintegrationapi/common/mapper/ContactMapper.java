package com.limadev.meetime.oauthintegrationapi.common.mapper;

import com.limadev.meetime.oauthintegrationapi.adapter.in.api.request.CreateContactRequest;
import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.request.HubSpotApiCreateContactRequest;
import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.request.HubSpotApiCreateContactRequest.Properties;
import com.limadev.meetime.oauthintegrationapi.application.domain.ContactDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ContactMapper {
        public HubSpotApiCreateContactRequest toRequest(ContactDomain domain) {
                if(domain == null) {
                        return null;
                }

                return HubSpotApiCreateContactRequest
                        .builder()
                        .properties(Properties
                                .builder()
                                .email(domain.getEmail())
                                .firstName(domain.getFirstName())
                                .lastName(domain.getLastName())
                                .phone(domain.getPhone())
                                .build())
                        .build();
        }

        public abstract ContactDomain toDomain(CreateContactRequest request);
}
