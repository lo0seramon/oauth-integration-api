package com.limadev.meetime.oauthintegrationapi.adapter.in.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateContactRequest {
    @NotBlank(message = "email não pode estar vazio")
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
