package com.limadev.meetime.oauthintegrationapi.adapter.in.api;

import com.limadev.meetime.oauthintegrationapi.adapter.in.api.response.AuthorizeResponse;
import com.limadev.meetime.oauthintegrationapi.application.business.port.in.GetAuthorizationUrlUseCase;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oauth")
@AllArgsConstructor
@Tag(name = "Oauth Controller", description = "Controller para o fluxo de autenticação")
public class OauthController {

    private GetAuthorizationUrlUseCase getAuthorizationUrlUseCase;

    @ApiResponse(
            description = "Retorno de sucesso para a criação de url",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthorizeResponse.class))
    )
    @GetMapping("v1/authorize")
    public ResponseEntity<AuthorizeResponse> getAuthorizationUrl() {
        return ResponseEntity.ok().body(AuthorizeResponse
                .builder()
                .authorizationUrl(getAuthorizationUrlUseCase.getAuthorizationUrl())
                .build());
    }
}
