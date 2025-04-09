package com.limadev.meetime.oauthintegrationapi.common.mapper;

import com.limadev.meetime.oauthintegrationapi.adapter.out.hubspot.thirdparty.response.HubSpotApiTokenResponse;
import com.limadev.meetime.oauthintegrationapi.application.domain.TokenDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenMapper {
    TokenDomain toDomain(HubSpotApiTokenResponse response);
}
