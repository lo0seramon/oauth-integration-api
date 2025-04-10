package com.limadev.meetime.oauthintegrationapi.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDomain {
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
