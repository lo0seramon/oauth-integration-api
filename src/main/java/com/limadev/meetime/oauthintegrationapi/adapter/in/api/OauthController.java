package com.limadev.meetime.oauthintegrationapi.adapter.in.api;

import com.limadev.meetime.oauthintegrationapi.adapter.in.api.response.AuthorizeResponse;
import com.limadev.meetime.oauthintegrationapi.application.business.port.in.ExchangeCodeForTokenUseCase;
import com.limadev.meetime.oauthintegrationapi.application.business.port.in.GetAuthorizationUrlUseCase;
import com.limadev.meetime.oauthintegrationapi.common.exception.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oauth")
@AllArgsConstructor
@Tag(name = "Oauth Controller", description = "Controller para o fluxo de autenticação")
public class OauthController {

    private GetAuthorizationUrlUseCase getAuthorizationUrlUseCase;
    private ExchangeCodeForTokenUseCase exchangeCodeForTokenUseCase;

    @Operation(summary = "Endpoint responsável por gerar uma URL de acesso.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token obtido com sucesso.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthorizeResponse.class))),
            @ApiResponse(responseCode = "405", description = "Método não permitido", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/v1/authorize")
    public ResponseEntity<AuthorizeResponse> getAuthorizationUrl() {
        return ResponseEntity.ok().body(AuthorizeResponse
                .builder()
                .authorizationUrl(getAuthorizationUrlUseCase.getAuthorizationUrl())
                .build());
    }

    @Operation(summary = "Endpoint responsável por receber um código e trocar por um token de acesso.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token obtido com sucesso.", content = @Content()),
            @ApiResponse(responseCode = "400", description = "Authorization code inválido ou inexistente.", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "Método não permitido", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/v1/callback")
    public ResponseEntity<Void> handleCallback(@RequestParam("code") String authorizationCode) {
        exchangeCodeForTokenUseCase.exchangeCodeForToken(authorizationCode);
        return ResponseEntity.ok().build();
    }
}
