package com.limadev.meetime.oauthintegrationapi.common.mapper;

import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.request.HubSpotApiCreateContactRequest;
import com.limadev.meetime.oauthintegrationapi.application.domain.ContactDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
        HubSpotApiCreateContactRequest toRequest(ContactDomain domain);
}
